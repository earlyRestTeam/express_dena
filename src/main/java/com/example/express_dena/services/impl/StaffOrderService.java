package com.example.express_dena.services.impl;

import com.example.express_dena.pojo.Order;
import com.example.express_dena.services.IStaffOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class StaffOrderService implements IStaffOrderService {
    @Override
    public PageInfo<Order> selectUserOrder(Integer indexpage, Integer status) {
        indexpage = indexpage == null ? 1: indexpage;
        status = status == null ? 1 : status;
        List<Order> orderList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Order order1 = new Order();
            order1.setOrderid(i);
            order1.setOrderno("20191211");
            order1.setUsername("张三" + i);
            order1.setCreateTime(new Date());
            order1.setTotalAmount(20f);
            order1.setStatus(1);
            order1.setEndTime(new Date());
            orderList.add(order1);
        }
        PageHelper.startPage(indexpage,10);
        PageInfo<Order> info = new PageInfo(orderList,5);
        return info;
    }

    @Override
    public PageInfo<Order> selectOrderBaoguo(Integer indexpage, String orderon) {
        return null;
    }

    @Override
    public boolean pickupUserOrder(Order o) {
        return true;
    }

    @Override
    public PageInfo<Order> selectUserOrder(Integer indexpage, Integer hosermanid,Integer status) {
        indexpage = indexpage == null ? 1: indexpage;

        HashMap<String,Object> pramas = new HashMap<>();
        if(hosermanid!=null){
            pramas.put("hosermanid",hosermanid);
        }
        if(status!=null){
            pramas.put("status",status);
        }


        List<Order> orderList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Order order1 = new Order();
            order1.setOrderid(i);
            order1.setOrderno("20191211");
            order1.setUsername("张三" + i);
            order1.setCreateTime(new Date());
            order1.setTotalAmount(20f);
            order1.setStatus(2);
            order1.setEndTime(new Date());
            orderList.add(order1);
        }
        PageHelper.startPage(indexpage,10);
        PageInfo<Order> info = new PageInfo(orderList,5);
        return info;
    }

    @Override
    public boolean filishOrder(Order o) {
        return false;
    }

    @Override
    public PageInfo<Order> selectUserHistoryOrder(Integer indexpage, Integer hosermanid,Integer status) {
        indexpage = indexpage == null ? 1: indexpage;

        HashMap<String,Object> pramas = new HashMap<>();
        if(hosermanid!=null){
            pramas.put("hosermanid",hosermanid);
        }
        if(status!=null){
            pramas.put("status",status);
        }


        List<Order> orderList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Order order1 = new Order();
            order1.setOrderid(i);
            order1.setOrderno("20191211");
            order1.setUsername("张三" + i);
            order1.setCreateTime(new Date());
            order1.setTotalAmount(20f);
            order1.setStatus(3);
            order1.setEndTime(new Date());
            orderList.add(order1);
        }
        PageHelper.startPage(indexpage,10);
        PageInfo<Order> info = new PageInfo(orderList,5);
        return info;
    }

    @Override
    public Order getOrderInfo(Integer orderid) {

            Order order1 = new Order();
            order1.setOrderid(12);
            order1.setOrderno("20191211");
            order1.setUsername("张三" + 12);
            order1.setCreateTime(new Date());
            order1.setTotalAmount(20f);
            order1.setStatus(1);
            order1.setEndTime(new Date());
            return order1;

    }
}
