package com.example.express_dena.services.impl;

import com.example.express_dena.mapper.OrderMapper;
import com.example.express_dena.pojo.Order;
import com.example.express_dena.pojo.OrderExample;
import com.example.express_dena.services.IStaffOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class StaffOrderService implements IStaffOrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public PageInfo<Order> selectUserOrder(Integer indexpage, Integer status) {
        indexpage = indexpage == null ? 1: indexpage;

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andStatusEqualTo(status);

        List<Order> orderList = orderMapper.selectByExample(orderExample);

        PageHelper.startPage(indexpage,10);
        PageInfo<Order> info = new PageInfo(orderList,5);
        return info;
    }

    @Override
    public PageInfo<Order> selectOrderBaoguo(Integer indexpage, String orderon) {
        return null;
    }

    @Override
    public boolean pickupUserOrder(Integer orderid) {
        Order order = orderMapper.selectByPrimaryKey(orderid);
        if(order!=null&&order.getStatus()==1){
            order.setStatus(2);
            order.setHosermanid(1);
            order.setHosermainPhone("13378052140");
            order.setHosermanName("铂金");
        }

        return orderMapper.updateByPrimaryKey(order) > 0;
    }

    @Override
    public PageInfo<Order> selectUserOrder(Integer indexpage, Integer hosermanid,Integer status) {
        indexpage = indexpage == null ? 1: indexpage;

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andHosermanidEqualTo(hosermanid).andStatusEqualTo(status);


        List<Order> orderList = orderMapper.selectByExample(orderExample);

        PageHelper.startPage(indexpage,10);
        PageInfo<Order> info = new PageInfo(orderList,5);
        return info;
    }

    @Override
    public boolean filishOrder(Integer orderid) {
        Order order = orderMapper.selectByPrimaryKey(orderid);
        if(order != null && order.getStatus()==2){
            order.setStatus(3);
            order.setEndTime(new Date());
        }
        return orderMapper.updateByPrimaryKey(order)>0;
    }

    @Override
    public PageInfo<Order> selectUserHistoryOrder(Integer indexpage, Integer hosermanid,Integer status) {
        indexpage = indexpage == null ? 1: indexpage;

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andHosermanidEqualTo(hosermanid).andStatusEqualTo(status);


        List<Order> orderList = orderMapper.selectByExample(orderExample);

        PageHelper.startPage(indexpage,10);
        PageInfo<Order> info = new PageInfo(orderList,5);
        return info;
    }

    @Override
    public PageInfo<Order> searchOrderInfo(String orderno) {

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOrdernoEqualTo(orderno);
        List<Order> orderList = orderMapper.selectByExample(orderExample);

        PageInfo<Order> info = new PageInfo(orderList,5);
        return info;
    }
}
