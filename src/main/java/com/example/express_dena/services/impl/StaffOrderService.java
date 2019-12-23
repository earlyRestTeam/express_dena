package com.example.express_dena.services.impl;

import com.example.express_dena.mapper.MessageMapper;
import com.example.express_dena.mapper.OrderMapper;
import com.example.express_dena.mapper.OrderdetailMapper;
import com.example.express_dena.pojo.*;
import com.example.express_dena.security.LoginEntityHelper;
import com.example.express_dena.services.IStaffOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import java.util.List;

@Service
public class StaffOrderService implements IStaffOrderService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    LoginEntityHelper loginEntityHelper;
    @Autowired
    OrderdetailMapper orderdetailMapper;
    @Autowired
    MessageMapper messageMapper;

    @Override
    public PageInfo<Order> selectUserOrder(Integer indexpage, Integer status) {
        indexpage = indexpage == null ? 1: indexpage;

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andStatusEqualTo(status);

        orderExample.setOrderByClause("create_time desc");

        PageHelper.startPage(indexpage,3);

        List<Order> orderList = orderMapper.selectByExample(orderExample);

        PageInfo<Order> pageInfo = new PageInfo<>(orderList,5);

        return pageInfo;
    }

    @Override
    public List<Orderdetail> selectOrderdetail(Integer orderid) {
        OrderdetailExample orderdetailExample = new OrderdetailExample();
        OrderdetailExample.Criteria criteria = orderdetailExample.createCriteria();
        criteria.andOrderidEqualTo(orderid);

        return orderdetailMapper.selectByExample(orderdetailExample);
    }

    @Override
    public Order selectOrderByOrderId(Integer orderid) {

        return orderMapper.selectByPrimaryKey(orderid);
    }


    @Override
    public boolean updatePickupUserOrder(Integer orderid) {
        Horseman horseman = loginEntityHelper.getEntityByClass(Horseman.class);
        if(horseman==null){
            throw new RuntimeException("error");
        }
        Order order = orderMapper.selectByPrimaryKey(orderid);

        if(order==null){
            throw new RuntimeException("error");
        }
        if(order.getStatus()==1){
            order.setStatus(2);
            order.setPickUpTime(new Date());
            order.setHosermanid(horseman.getId());
            order.setHosermainPhone(horseman.getPhone());
            order.setHosermanName(horseman.getUsername());
        }

        if(orderMapper.updateByPrimaryKeySelective(order) == 0){
            throw new RuntimeException("error");
        }
        System.out.println("receiverId:"+order.getUserid());
        //发消息给客户
        Message messageToUser = new Message();
        messageToUser.setReceiverid(order.getUserid());
        messageToUser.setReceiverType(1);
        messageToUser.setStatus(1);
        messageToUser.setSendTime(new Date());
        messageToUser.setContent("您的订单号为："+order.getOrderno()+"的订单已被领取！");
        if(messageMapper.insert(messageToUser) == 0){
            throw new RuntimeException("error");
        }


        //发消息给骑手
        Message messageToHorseman = new Message();
        messageToHorseman.setReceiverid(horseman.getId());
        messageToHorseman.setReceiverType(2);
        messageToHorseman.setStatus(1);
        messageToHorseman.setSendTime(new Date());
        messageToHorseman.setContent("订单号为："+ order.getOrderno() +"的订单已被领取！");
        if(messageMapper.insert(messageToHorseman) == 0){
            throw new RuntimeException("error");
        }


        return true;
    }

    @Override
    public PageInfo<Order> selectUserOrder(Integer indexpage, Integer hosermanid,Integer status) {
        indexpage = indexpage == null ? 1: indexpage;

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andHosermanidEqualTo(hosermanid).andStatusEqualTo(status);
        orderExample.setOrderByClause("pick_up_time desc");

        PageHelper.startPage(indexpage,5);

        List<Order> orderList = orderMapper.selectByExample(orderExample);

        PageInfo<Order> info = new PageInfo<>(orderList,5);

        return info;
    }

    @Override
    public boolean updateFinishOrder(Integer orderid, Integer hosermanid,Integer status) {
        Order order = orderMapper.selectByPrimaryKey(orderid);
        if(order==null){
            throw new RuntimeException("error");
        }
        if(order.getStatus().equals(status) && order.getHosermanid().equals(hosermanid)){
            order.setComfirmHosemanStatus(1);
            order.setSendTime(new Date());


        }
        if(orderMapper.updateByPrimaryKeySelective(order) == 0){
            throw new RuntimeException("error");
        }
        //发消息给客户
        Message messageToUser = new Message();
        messageToUser.setReceiverid(order.getUserid());
        messageToUser.setReceiverType(1);
        messageToUser.setStatus(1);
        messageToUser.setSendTime(new Date());
        messageToUser.setContent("您的订单号为："+order.getOrderno()+"的订单已送达！请确认收货。");
        if(messageMapper.insert(messageToUser) == 0){
            throw new RuntimeException("error");
        }


        //发消息给骑手
        Message messageToHorseman = new Message();
        messageToHorseman.setReceiverid(hosermanid);
        messageToHorseman.setReceiverType(2);
        messageToHorseman.setStatus(1);
        messageToHorseman.setSendTime(new Date());
        messageToHorseman.setContent("订单号为："+ order.getOrderno() +"的订单已送达！");
        if(messageMapper.insert(messageToHorseman) == 0){
            throw new RuntimeException("error");
        }
        return true;
    }

    @Override
    public PageInfo<Order> selectUserHistoryOrder(Integer indexpage, Integer hosermanid,Integer status,Integer showHosemanStatus) {
        indexpage = indexpage == null ? 1: indexpage;

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andHosermanidEqualTo(hosermanid).andStatusEqualTo(status).andShowHosemanStatusEqualTo(showHosemanStatus);
        orderExample.setOrderByClause("end_time desc");

        PageHelper.startPage(indexpage,5);

        List<Order> orderList = orderMapper.selectByExample(orderExample);

        PageInfo<Order> info = new PageInfo<>(orderList,5);

        return info;
    }

    @Override
    public PageInfo<Order> searchNoGetOrderInfo(Integer indexpage, String orderno, Integer status) {
        indexpage = indexpage == null ? 1: indexpage;

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOrdernoLike(orderno+"%").andStatusEqualTo(status);



        PageHelper.startPage(indexpage,5);
        List<Order> orderList = orderMapper.selectByExample(orderExample);
        PageInfo<Order> info = new PageInfo<>(orderList,5);
        return info;
    }

    @Override
    public PageInfo<Order> searchGetOrderInfo(Integer indexpage, String orderno, Integer hosermanid, Integer status) {
        indexpage = indexpage == null ? 1: indexpage;

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOrdernoLike(orderno+"%").andStatusEqualTo(status).andHosermanidEqualTo(hosermanid);

        PageHelper.startPage(indexpage,5);
        List<Order> orderList = orderMapper.selectByExample(orderExample);
        PageInfo<Order> info = new PageInfo<>(orderList,5);
        return info;
    }

    @Override
    public PageInfo<Order> searchHistoryOrder(Integer indexpage, Integer hosermanid, String orderno, Integer status, Integer showHosemanStatus) {
        indexpage = indexpage == null ? 1: indexpage;

        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andOrdernoLike(orderno+"%").andStatusEqualTo(status).andShowHosemanStatusEqualTo(showHosemanStatus).andHosermanidEqualTo(hosermanid);


        PageHelper.startPage(indexpage,5);
        List<Order> orderList = orderMapper.selectByExample(example);
        PageInfo<Order> info = new PageInfo<>(orderList,5);
        return info;
    }

    @Override
    public boolean deleteStaffOrder(Integer orderid, Integer hosermanid, Integer status, Integer showHosemanStatus) {
        Order order = orderMapper.selectByPrimaryKey(orderid);
        if(order!=null && order.getHosermanid()==hosermanid && order.getStatus()==status && order.getShowHosemanStatus()==showHosemanStatus){
            order.setShowHosemanStatus(1);
            return orderMapper.updateByPrimaryKeySelective(order)>0;
        }
        return false;
    }

    @Override
    public long selectFinishOrderNum(Integer indexpage, Integer hosermanid, Integer status) {
        indexpage = indexpage == null ? 1: indexpage;

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andHosermanidEqualTo(hosermanid).andStatusEqualTo(status);

        PageHelper.startPage(indexpage,5);
        List<Order> orderList = orderMapper.selectByExample(orderExample);
        PageInfo<Order> info = new PageInfo<>(orderList,5);
        return info.getTotal();
    }
}
