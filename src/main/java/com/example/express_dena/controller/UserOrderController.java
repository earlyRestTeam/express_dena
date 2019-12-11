package com.example.express_dena.controller;

import com.example.express_dena.services.UserOrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author :Yang Jiahong
 * @date :2019/12/11 16:03
 */
@Controller
public class UserOrderController {

    @Autowired
    UserOrderService service;


    @RequestMapping("currentUserOrder")
    public String selectOrderCurrent(Integer indexpage, HttpServletRequest request){
        int userid = 1;
        PageInfo info = service.selectOrderCurrent(userid,indexpage);
        request.setAttribute("page",info);
        return "/currentUserOrder.html";
    }

    @RequestMapping("userHistoryOrder")
    public String selectuserHistoryOrder(Integer indexpage, HttpServletRequest request){
        int userid = 1;
        PageInfo info = service.selectOrderCurrent(userid,indexpage);
        request.setAttribute("page",info);
        return "/userHistoryOrder";
    }

    @RequestMapping("submitOrder")
    public String selectsubmitOrder(){
        return "/submitOrder";
    }

    @RequestMapping("payOrder")
    public String returnpayOrder(){
        return "/payOrder";
    }


}
