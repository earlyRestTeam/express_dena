package com.example.express_dena.services.impl;

import com.alipay.api.AlipayApiException;
import com.example.express_dena.mapper.CommentMapper;
import com.example.express_dena.mapper.HorsemanMapper;
import com.example.express_dena.mapper.OrderMapper;
import com.example.express_dena.mapper.OrderdetailMapper;
import com.example.express_dena.pojo.*;
import com.example.express_dena.security.LoginEntityHelper;
import com.example.express_dena.services.IAliPayService;
import com.example.express_dena.services.IMessageService;
import com.example.express_dena.services.UserOrderService;
import com.example.express_dena.util.PayException;
import com.example.express_dena.util.StaticPool;
import com.github.pagehelper.PageException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    OrderdetailMapper orderdetailMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    HorsemanMapper horsemanMapper;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    IMessageService iMessageService;

    @Autowired
    IAliPayService iAliPayService;

    //提交订单
    @Override
    public Map<String, String> insertOrder(Order order, List<Orderdetail> orderdetails) {
        Map<String, String> map = new HashMap<>();
        order.setCreateTime(new Date());            //设置订单创建时间
        order.setStatus(5);                         //设置订单初始状态5 未支付
        order.setShowuserstatus(0);                 //设置用户可见初始状态0 （未删除历史订单）
        order.setShowHosemanStatus(0);              //设置骑手可见初始状态0 （未删除历史订单）
        order.setComfirmUserStatus(0);              //设置用户确认完成
        order.setComfirmHosemanStatus(0);          //设置骑手确认完成
        order.setCommentNum(orderdetails.size());  //快递包裹个数
        order.setRemark1("未评论，点击评论");

        LoginEntityHelper loginEntityHelper = new LoginEntityHelper();
        User user = new User();
        if (loginEntityHelper.getEntityByClass(User.class) != null) {
            user = loginEntityHelper.getEntityByClass(User.class);
        }

        if (user.getId() != null) {
            order.setUserid(user.getId());
        } else {
            order.setUserid(1);
        }
        int result = orderMapper.insert(order);

        List<Order> orderid = new ArrayList<>();
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOrdernoEqualTo(order.getOrderno());
        if (result > 0) {
            orderid = orderMapper.selectByExample(orderExample);
        }

        for (int i = 0; i < orderdetails.size(); i++) {
            orderdetails.get(i).setOrderid(orderid.get(0).getId());
        }

        int orderdetailsResult = orderdetailMapper.insertallDetails(orderdetails);

        if (orderdetailsResult > 0 && result > 0) {
            map.put(StaticPool.SUCCESS, "发布失败");
        } else {
            map.put(StaticPool.ERROR, "发布成功");
        }
        return map;
    }

    //查询当前订单
    @Override
    public PageInfo selectOrderCurrent(int userid, Integer indexpage,String serchid) {
        OrderExample orderExample = new OrderExample();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(5);
        if (serchid != null&&!"null".equals(serchid)){

            orderExample.or().andUseridEqualTo(userid).andOrdernoLike(serchid+"%").andStatusIn(list1);
        }else {
            orderExample.or().andUseridEqualTo(userid).andStatusIn(list1);
        }
        indexpage = indexpage == null ? 1 : indexpage;

        PageHelper.startPage(indexpage, 7);

        List<Order> list = orderMapper.selectByExample(orderExample);

        PageInfo info = new PageInfo(list, 3);

        return info;

    }

    //查询历史订单
    @Override
    public PageInfo selectHistoryOrder(int userid, Integer indexpage,String serchid) {

        OrderExample orderExample = new OrderExample();
        orderExample.setOrderByClause("end_time desc");
        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(4);
        if (serchid != null && !"null".equals(serchid)) {
            orderExample.or().andStatusIn(list1)
                    .andShowuserstatusEqualTo(0)
                    .andUseridEqualTo(userid)
                    .andHosermanNameLike(serchid + "%");
            orderExample.or().andStatusIn(list1)
                    .andShowuserstatusEqualTo(0)
                    .andUseridEqualTo(userid)
                    .andOrdernoLike(serchid + "%");
        } else {
            orderExample.or().andStatusIn(list1)
                    .andShowuserstatusEqualTo(0)
                    .andUseridEqualTo(userid);
        }

        indexpage = indexpage == null ? 1 : indexpage;

        PageHelper.startPage(indexpage, 7);

        List<Order> list = orderMapper.selectByExample(orderExample);

        PageInfo info = new PageInfo(list, 3);

        return info;
    }

    //根据id查询订单详情
    @Override
    public Order selectOrderById(int orderid) {
        Order order = orderMapper.selectByPrimaryKey(orderid);
        if (order != null) {
            return order;
        } else {
            return null;
        }
    }

    //根据orderid查询该订单的所有包裹详情
    @Override
    public List<Orderdetail> selectOrderdetailById(int orderid) {
        OrderdetailExample orderdetailExample = new OrderdetailExample();
        OrderdetailExample.Criteria criteria = orderdetailExample.createCriteria();
        criteria.andOrderidEqualTo(orderid);
        List<Orderdetail> list = orderdetailMapper.selectByExample(orderdetailExample);
        if (list != null) {
            return list;
        } else {
            return null;
        }
    }

    //删除已完成订单
    @Override
    public Map<String, String> deleteUserOrderByID(int orderid) {
        Map<String, String> res = new HashMap<>();
        Order order1 = orderMapper.selectByPrimaryKey(orderid);
        if (order1 == null)
            throw new PayException("订单异常");

        LoginEntityHelper loginEntityHelper = new LoginEntityHelper();
        User user = loginEntityHelper.getEntityByClass(User.class);

        if(order1.getUserid() != user.getId())
            throw new PayException("登陆异常");

        order1.setShowuserstatus(1);
        int result = orderMapper.updateByPrimaryKey(order1);
        if (result > 0) {
            res.put(StaticPool.SUCCESS, "删除成功");
        } else {
            res.put(StaticPool.ERROR, "删除失败");
        }
        return res;
    }

    //查询订单状态
    @Override
    public int selectStatus(int orderid) {
        OrderExample example = new OrderExample();
//        example.or().andOrderidEqualTo(orderid);
        Order order = (Order) orderMapper.selectByExample(example);
        int status = order.getStatus();
        return status;
    }

    //取消订单
    @Override
    public Map<String, String> updateCancelOrderByID(int orderid) throws PayException {

        Map<String, String> res = new HashMap<>();
        Order order1 = orderMapper.selectByPrimaryKey(orderid);   //根据订单编号查询订单信息

        if (order1 == null)
            throw new PayException("取消异常");

        LoginEntityHelper loginEntityHelper = new LoginEntityHelper();
        User user = loginEntityHelper.getEntityByClass(User.class);

        if (user == null && order1.getUserid() != user.getId() && order1.getStatus() != 1)
            throw new PayException("登陆状态异常");

        order1.setStatus(4);
        int result = orderMapper.updateByPrimaryKey(order1);

        if (result <= 0)
            throw new PayException("取消订单失败");

        Message usermessage = new Message();     //发给用户信息
        usermessage.setReceiverid(order1.getUserid());
        String content = "您的订单编号为" + order1.getOrderno() + "已取消";
        usermessage.setContent(content);         //设置发送内容
        usermessage.setReceiverType(1);          //设置发送用户类型 1.普通用户 2.骑手
        usermessage.setSendTime(new Date());     //设置发送时间
        usermessage.setStatus(1);                //设置信息状态 1.未读 2.已读
        Map<String, String> userres = new HashMap<>();
        userres = iMessageService.sendMessage(usermessage);    //给用户发送取消订单结果信息

        if (userres.get(StaticPool.SUCCESS) == null)
            throw new PayException("发送消息异常");

        String s = null;
        try {
            s = iAliPayService.refund(order1.getOrderno(), order1.getTotalAmount().toString());
        } catch (AlipayApiException e) {
            throw new PayException(e.getMessage());
        }

        if (!s.contains("Success"))
            throw new PayException("取消失败");

        res.put(StaticPool.SUCCESS, "取消成功");
        return res;

    }

    @Override
    public Map<String, String> selectOrderDetail(int orderid) {
        return null;
    }

    //确认完成订单
    @Override
    public Map<String, String> updateCompleteOrder(int orderid) {

        Map<String, String> res = new HashMap<>();
        Order order1 = orderMapper.selectByPrimaryKey(orderid);
        if (order1 == null)
            throw new PayException("订单号异常");

        LoginEntityHelper loginEntityHelper = new LoginEntityHelper();
        User user = loginEntityHelper.getEntityByClass(User.class);

        if (user == null && order1.getUserid() != user.getId() && order1.getStatus() != 2)
            throw new PayException("登陆状态异常");

        order1.setComfirmUserStatus(1);
        order1.setStatus(3);
        order1.setEndTime(new Date());
        int result = orderMapper.updateByPrimaryKey(order1);
        int hosermanid = order1.getHosermanid();
        float balance = order1.getTotalAmount();

        Message usermessage = new Message();     //发给用户信息
        usermessage.setReceiverid(order1.getUserid());
        String content = "您的订单编号为" + order1.getOrderno() + "已完成";
        usermessage.setContent(content);         //设置发送内容
        usermessage.setReceiverType(1);          //设置发送用户类型 1.普通用户 2.骑手
        usermessage.setSendTime(new Date());     //设置发送时间
        usermessage.setStatus(1);                //设置信息状态 1.未读 2.已读


        Message hosermanmessage = new Message();     //发给骑手信息
        hosermanmessage.setReceiverid(order1.getUserid());
        String hosercontent = "您的订单编号为" + order1.getOrderno() + "已完成,到账" + order1.getTotalAmount() + "元";
        hosermanmessage.setContent(hosercontent);         //设置发送内容
        hosermanmessage.setReceiverType(2);          //设置发送用户类型 1.普通用户 2.骑手
        hosermanmessage.setSendTime(new Date());     //设置发送时间
        hosermanmessage.setStatus(1);                //设置信息状态 1.未读 2.已读

        if (result <= 0)
            throw new PayException("订单完成异常");

        Horseman horseman = horsemanMapper.selectByPrimaryKey(hosermanid);
        float newbalance = balance + horseman.getBalance();
        horseman.setBalance(newbalance);

        //给骑手打款
        int balanceresult = horsemanMapper.updateByPrimaryKey(horseman);

        if (balanceresult <= 0)
            throw new PayException("打款异常");

        Map<String, String> userres = new HashMap<>();
        Map<String, String> hoserres = new HashMap<>();
        //发送短信
        userres = iMessageService.sendMessage(usermessage);   //给用户发送信息
        hoserres = iMessageService.sendMessage(hosermanmessage); //给骑手发送信息

        if (userres.get(StaticPool.SUCCESS) == null || hoserres.get(StaticPool.SUCCESS) == null)
                  throw new PayException("消息异常");

        res.put(StaticPool.SUCCESS, "订单完成");
        return res;
    }

    //添加评论
    @Override
    public Map<String, String> insertComments(Comment comment) {
        int orderid = comment.getOrderId();
        Order order = orderMapper.selectByPrimaryKey(orderid);

        if(order == null)
            throw new PayException("订单状态异常");

        LoginEntityHelper loginEntityHelper = new LoginEntityHelper();
        User user = loginEntityHelper.getEntityByClass(User.class);

        if(order.getUserid() != user.getId())
            throw new PayException("登陆状态异常状态异常");


        if(order.getRemark1().equals("未评论，点击评论")){
            order.setRemark1("以评论，再评论?");
            int updateorder = orderMapper.updateByPrimaryKey(order);
            int result = commentMapper.insert(comment);
            Map<String, String> res = new HashMap<>();
            if(result > 0 && updateorder > 0){
                res.put(StaticPool.SUCCESS,"评论成功");
            }else{
                res.put(StaticPool.SUCCESS,"评论失败");
            }
            return res;
        }else{
            int result = commentMapper.insert(comment);
            Map<String, String> res = new HashMap<>();
            if(result > 0){
                res.put(StaticPool.SUCCESS,"评论成功");
            }else{
                res.put(StaticPool.SUCCESS,"评论失败");
            }
            return res;
        }
    }

    @Override
    public int selectOrderCountByUseridAndOrderStatus(int userid, int status) {
        OrderExample example = new OrderExample();
        example.createCriteria().andUseridEqualTo(userid).andStatusEqualTo(status);
        List<Order> list = orderMapper.selectByExample(example);
        return list == null ? 0 : list.size();
    }


    //根据订单编号查询
    @Override
    public Order selecteOrderByNO(String orderno) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOrdernoEqualTo(orderno);
        List<Order> order = new ArrayList<>();
        Order order1 = new Order();
        order =  orderMapper.selectByExample(orderExample);
        if(order != null){
            order1  = order.get(0);
            return order1;
        }
        return null;
    }

    //是未支付订单状态变为未结单
    @Override
    public int updatePickOrder(int orderid) {
        Order order = orderMapper.selectByPrimaryKey(orderid);
        order.setStatus(1);  //修改未未结单状态
        int result = orderMapper.updateByPrimaryKey(order);
        return result;
    }

    @Override
    public Map<String, String> updateSysCompleteOrder(int orderid) {
        Map<String, String> res = new HashMap<>();
        Order order1 = orderMapper.selectByPrimaryKey(orderid);
        if (order1 == null)
            throw new PayException("订单号异常");

        if (order1.getStatus() != 2)
            throw new PayException("订单状态异常");

        order1.setComfirmUserStatus(1);
        order1.setStatus(3);
        order1.setEndTime(new Date());
        int result = orderMapper.updateByPrimaryKey(order1);
        int hosermanid = order1.getHosermanid();
        float balance = order1.getTotalAmount();

        Message usermessage = new Message();     //发给用户信息
        usermessage.setReceiverid(order1.getUserid());
        String content = "您的订单编号为" + order1.getOrderno() + "已完成";
        usermessage.setContent(content);         //设置发送内容
        usermessage.setReceiverType(1);          //设置发送用户类型 1.普通用户 2.骑手
        usermessage.setSendTime(new Date());     //设置发送时间
        usermessage.setStatus(1);                //设置信息状态 1.未读 2.已读


        Message hosermanmessage = new Message();     //发给骑手信息
        hosermanmessage.setReceiverid(order1.getUserid());
        String hosercontent = "您的订单编号为" + order1.getOrderno() + "已完成,到账" + order1.getTotalAmount() + "元";
        hosermanmessage.setContent(content);         //设置发送内容
        hosermanmessage.setReceiverType(2);          //设置发送用户类型 1.普通用户 2.骑手
        hosermanmessage.setSendTime(new Date());     //设置发送时间
        hosermanmessage.setStatus(1);                //设置信息状态 1.未读 2.已读

        if (result <= 0)
            throw new PayException("订单完成异常");

        Horseman horseman = horsemanMapper.selectByPrimaryKey(hosermanid);
        float newbalance = balance + horseman.getBalance();
        horseman.setBalance(newbalance);

        //给骑手打款
        int balanceresult = horsemanMapper.updateByPrimaryKey(horseman);

        if (balanceresult <= 0)
            throw new PayException("打款异常");

        Map<String, String> userres = new HashMap<>();
        Map<String, String> hoserres = new HashMap<>();
        //发送短信
        userres = iMessageService.sendMessage(usermessage);   //给用户发送信息
        hoserres = iMessageService.sendMessage(hosermanmessage); //给骑手发送信息

        if (userres.get(StaticPool.SUCCESS) == null || hoserres.get(StaticPool.SUCCESS) == null)
            throw new PayException("消息异常");

        res.put(StaticPool.SUCCESS, "订单完成");
        return res;
    }


}

