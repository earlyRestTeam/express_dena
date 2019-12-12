package com.example.express_dena.services.impl;

import com.example.express_dena.mapper.OrderMapper;
import com.example.express_dena.pojo.Order;
import com.example.express_dena.pojo.OrderExample;
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

    @Override
    public PageInfo<Order> selectUserOrder(Integer indexpage, Integer status) {
        indexpage = indexpage == null ? 1: indexpage;

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andStatusEqualTo(status);

        PageHelper.startPage(indexpage,3);
        List<Order> orderList = orderMapper.selectByExample(orderExample);
        PageInfo<Order> info = new PageInfo<>(orderList,5);

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

        PageHelper.startPage(indexpage,5);
        List<Order> orderList = orderMapper.selectByExample(orderExample);
        PageInfo<Order> info = new PageInfo<>(orderList,5);
        return info;
    }

    @Override
    public boolean filishOrder(Integer orderid, Integer hosermanid,Integer status) {
        Order order = orderMapper.selectByPrimaryKey(orderid);
        if(order != null && order.getStatus()==status && order.getHosermanid()==hosermanid){
            order.setStatus(3);
            order.setEndTime(new Date());
            return orderMapper.updateByPrimaryKey(order)>0;
        }
        return false;
    }

    @Override
    public PageInfo<Order> selectUserHistoryOrder(Integer indexpage, Integer hosermanid,Integer status,Integer showHosemanStatus) {
        indexpage = indexpage == null ? 1: indexpage;

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andHosermanidEqualTo(hosermanid).andStatusEqualTo(status).andShowHosemanStatusEqualTo(showHosemanStatus);

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
            return orderMapper.updateByPrimaryKey(order)>0;
        }
        return false;
    }
}
