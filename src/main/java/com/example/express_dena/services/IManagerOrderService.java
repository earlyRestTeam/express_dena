package com.example.express_dena.services;

import com.example.express_dena.pojo.Order;

import com.github.pagehelper.PageInfo;

import java.util.Date;


public interface IManagerOrderService {

    /**
     * 查询订单
     * @param indexpage
     * @param orderno
     * @param username
     * @param hosermanName
     * @return
     */
    PageInfo selectOrder(Integer indexpage, String orderno, String username, String hosermanName);
}
