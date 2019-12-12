package com.example.express_dena.services.impl;

import com.example.express_dena.mapper.OrderMapper;
import com.example.express_dena.mapper.OrderdetailMapper;
import com.example.express_dena.pojo.Order;
import com.example.express_dena.pojo.OrderExample;
import com.example.express_dena.pojo.Orderdetail;
import com.example.express_dena.services.UserOrderService;
import com.example.express_dena.util.StaticPool;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :Yang Jiahong
 * @date :2019/12/10 22:59
 */
@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    OrderdetailMapper orderdetailMapper;

    @Autowired
    OrderMapper orderMapper;

    //提交订单
    @Override
    public Map<String, String> submitOrder(Order order, List<Orderdetail> orderdetails) {
        Map<String,String> map = new HashMap<>();
        int orderdetailsResult = orderdetailMapper.insertallDetails(orderdetails);
        if(orderdetailsResult>0){
            System.out.println("物件成功");
        }
        int orderResult = orderMapper.insert(order);
        if(orderdetailsResult>0 && orderResult > 0){

            map.put(StaticPool.SUCCESS,"发布失败");
        }else{
            map.put(StaticPool.ERROR ,"发布成功");
        }
        return map;
    }

    //查询当前订单
    @Override
    public  PageInfo selectOrderCurrent(int userid, Integer indexpage) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();

        criteria.andUseridEqualTo(userid);
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        criteria.andStatusIn(list1);


        indexpage = indexpage == null ? 1: indexpage;

        PageHelper.startPage(indexpage,7);

        List<Order> list = orderMapper.selectByExample(orderExample);

        PageInfo info = new PageInfo(list,3);

        return info;
    }

    //查询历史订单
    @Override
    public PageInfo selectHistoryOrder(int userid, Integer indexpage) {

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(4);
        criteria.andStatusIn(list1);
        criteria.andShowuserstatusEqualTo(0);

        indexpage = indexpage == null ? 1: indexpage;

        PageHelper.startPage(indexpage,7);

        List<Order> list = orderMapper.selectByExample(orderExample);

        PageInfo info = new PageInfo(list,3);

        return info;
    }

    //删除已完成订单
    @Override
    public Map<String, String> deleteOrderByID(int orderid) {
        Map<String,String> res = new HashMap<>();
        Order order1 = orderMapper.selectByPrimaryKey(orderid);
        System.out.println(order1.toString());
        order1.setShowuserstatus(1);
        int result = orderMapper.updateByPrimaryKey(order1);
        if(result>0){
            res.put(StaticPool.SUCCESS,"删除成功");
        }else{
            res.put(StaticPool.ERROR,"删除失败");
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
    public Map<String, String> cancelOrderByID(int orderid) {

        Map<String,String> res = new HashMap<>();
        Order order1 = orderMapper.selectByPrimaryKey(orderid);
        System.out.println(order1.toString());
        order1.setStatus(4);
        int result = orderMapper.updateByPrimaryKey(order1);
        if(result>0){
            res.put(StaticPool.SUCCESS,"取消成功");
        }else{
            res.put(StaticPool.ERROR,"取消失败");
        }
        return res;
    }

    //查询订单详情
    @Override
    public Map<String, String> selectOrderDetail(int orderid) {
        return null;
    }

    //确认完成订单
    @Override
    public Map<String, String> completeOrder(int orderid) {
        Map<String,String> res = new HashMap<>();
        Order order1 = orderMapper.selectByPrimaryKey(orderid);
        System.out.println(order1.toString());
        order1.setComfirmUserStatus(1);
        int result = orderMapper.updateByPrimaryKey(order1);
        if(result>0){
            res.put(StaticPool.SUCCESS,"订单完成");
        }else{
            res.put(StaticPool.ERROR,"订单异常");
        }
        return res;
    }

    //评论
    @Override
    public Map<String, String> comments(int userid, String contenr, int orderid, int hosemanid) {
        return null;
    }

    @Override
    public int selectOrderCountByUseridAndOrderStatus(int userid, int status) {
        OrderExample example = new OrderExample();
        example.createCriteria().andUseridEqualTo(userid).andStatusEqualTo(status);
        List<Order> list = orderMapper.selectByExample(example);
        return list == null ? 0 : list.size();
    }

}