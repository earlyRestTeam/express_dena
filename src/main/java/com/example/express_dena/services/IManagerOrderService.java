package com.example.express_dena.services;

import com.example.express_dena.pojo.Order;

import com.github.pagehelper.PageInfo;

import java.util.Date;


/**
 * @author 谢晓峰
 * @Classname IManagerOrderService
 * @Description TODO
 * @Date 2019/12/11 10:36
 * @Version V1.0
 */
public interface IManagerOrderService {

    /**
     * 查询订单
     * @param indexpage
     * @param orderno
     * @param username
     * @param hosermanName
     * @param createTimeMin
     * @param createTimeMax
     * @param endTimeMin
     * @param endTimeMax
     * @param status
     * @return
     */
    PageInfo selectOrder(Integer indexpage, String orderno, String username, String hosermanName,
                         Date createTimeMin, Date createTimeMax, Date endTimeMin, Date endTimeMax,
                         Integer status);
}
