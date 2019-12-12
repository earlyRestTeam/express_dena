package com.example.express_dena.services;

import com.example.express_dena.pojo.Order;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;

//骑手订单管理
public interface IStaffOrderService {

    //查看平台所有未接单的用户订单 zbo17
    PageInfo<Order> selectUserOrder(Integer indexpage, Integer status);
    //根据订单号查看订单下所有包裹信息
    PageInfo<Order> selectOrderBaoguo(Integer indexpage, String orderon);
    //领取任务,给订单增加骑手信息
    boolean pickupUserOrder(Integer orderid);
    //查看领取的任务 pramas:hosermanid和任务状态status（未完成）
    PageInfo<Order> selectUserOrder(Integer indexpage, Integer hosermanid,Integer status);
    //完成任务
    boolean filishOrder(Integer orderid, Integer hosermanid,Integer status);
    //查看历史任务  pramas:hosermanid和任务状态status（已完成）
    PageInfo<Order> selectUserHistoryOrder(Integer indexpage, Integer hosermanid,Integer status,Integer showHosemanStatus);
    //搜索未领取订单
    PageInfo<Order> searchNoGetOrderInfo(Integer indexpage, String orderno, Integer status);
    //搜索已领取订单
    PageInfo<Order> searchGetOrderInfo(Integer indexpage, String orderno,Integer hosermanid, Integer status);
    //搜索历史订单
    PageInfo<Order> searchHistoryOrder(Integer indexpage, Integer hosermanid, String orderno, Integer status, Integer showHosemanStatus);
    //删除历史订单
    boolean deleteStaffOrder(Integer orderid,Integer hosermanid,Integer status,Integer showHosemanStatus);
    //查看完成的订单数
    long selectFinishOrderNum(Integer indexpage, Integer hosermanid,Integer status);

}

