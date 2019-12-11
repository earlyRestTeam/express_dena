package com.example.express_dena.services.impl;

import com.example.express_dena.mapper.OrderMapper;
import com.example.express_dena.mapper.OrderdetailMapper;
import com.example.express_dena.pojo.Order;
import com.example.express_dena.pojo.OrderExample;
import com.example.express_dena.pojo.Orderdetail;
import com.example.express_dena.services.UserOrderService;
import com.example.express_dena.util.StaticPool;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Map<String, String> submitOrder(int userid, Order order, List<Orderdetail> orderdetails) {
        return null;
    }

    //查询当前订单
    @Override
    public  PageInfo selectOrderCurrent(int userid, Integer indexpage) {
        OrderExample orderExample = new OrderExample();
        int status = 1;
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        criteria.andStatusEqualTo(status);

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
        int status = 3;
        orderExample.or().andUseridEqualTo(userid);
        orderExample.or().andStatusEqualTo(status);

        indexpage = indexpage == null ? 1: indexpage;

        PageHelper.startPage(indexpage,7);

        List<Order> list = orderMapper.selectByExample(orderExample);

        PageInfo info = new PageInfo(list,3);

        return info;
    }

    //删除已完成订单
    @Override
    public Map<String, String> deleteOrderByID(int userid, int orderid) {


        return null;
    }

    //查询订单状态
    @Override
    public int selectStatus(int orderid) {
        OrderExample example = new OrderExample();
        example.or().andOrderidEqualTo(orderid);
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
    public Map<String, String> completeOrder(int Orderid) {
        return null;
    }

    //评论
    @Override
    public Map<String, String> comments(int userid, String contenr, int orderid, int hosemanid) {
        return null;
    }

}