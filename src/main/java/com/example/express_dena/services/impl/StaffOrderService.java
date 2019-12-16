package com.example.express_dena.services.impl;

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

    @Override
    public PageInfo<Order> selectUserOrder(Integer indexpage, Integer status) {
        indexpage = indexpage == null ? 1: indexpage;

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andStatusEqualTo(status);

        orderExample.setOrderByClause("create_time desc");

        PageHelper.startPage(indexpage,3);

        List<Order> orderList = orderMapper.selectByExample(orderExample);

        PageInfo<Order> info = new PageInfo<>(orderList,5);

        return info;
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
        if(order!=null&&order.getStatus()==1){
            order.setStatus(2);
            order.setHosermanid(horseman.getId());
            order.setHosermainPhone(horseman.getPhone());
            order.setHosermanName(horseman.getUsername());
        }

        return orderMapper.updateByPrimaryKey(order) > 0;
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
        if(order != null && order.getStatus()==status && order.getHosermanid()==hosermanid){
            order.setComfirmHosemanStatus(1);
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
            return orderMapper.updateByPrimaryKey(order)>0;
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
