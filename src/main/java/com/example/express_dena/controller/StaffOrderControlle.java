package com.example.express_dena.controller;

import com.example.express_dena.pojo.Order;
import com.example.express_dena.services.impl.StaffOrderService;
import com.github.pagehelper.PageInfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping("/staff")
public class StaffOrderControlle {
    StaffOrderService staffOrderService = new StaffOrderService();

    //平台订单
    @RequestMapping("currentStaffOrder")
    public String currentStaffOrder(Integer indexpage, HttpServletRequest request){

        System.out.println("indexpage:" + indexpage);
        Integer status = 1;
        PageInfo pageInfo = staffOrderService.selectUserOrder(indexpage,status);
        request.setAttribute("pages",pageInfo);
        System.out.println(pageInfo.getList());
        return "/staff/currentStaffOrder";
    }
    //当订单详情页面
    @RequestMapping("detailsOrder")
    public String detailsOrder(){
        return "/staff/detailsOrder";
    }

    //当前订单跳转1
    @RequestMapping("getOrder")
    public String etOrder(Integer orderid){
        Order order = staffOrderService.getOrderInfo(orderid);
        if(order!=null && order.getStatus()==1){
            order.setHosermanid(1);
            order.setHosermainPhone("13378052140");
            order.setHosermanName("铂金");
        }
        staffOrderService.pickupUserOrder(order);
        return "redirect:/staff/staffGetOrder?indexpage=1&hosermanid=1";
    }

    //领取的订单列表
    @RequestMapping("staffGetOrder")
    public String staffGetOrdergList(Integer indexpage, Integer hosermanid, HttpServletRequest request){


        System.out.println("indexpage:" + indexpage);
        System.out.println("hosermanid:" + hosermanid);
        PageInfo pageInfo = staffOrderService.selectUserOrder(indexpage,hosermanid,1);
        request.setAttribute("pages",pageInfo);
        System.out.println(pageInfo.getList());
        return "/staff/staffGetOrder";
    }

    //历史订单界面
    @RequestMapping("staffHistoryOrder")
    public String staffHistoryOrder(Integer indexpage, Integer hosermanid, HttpServletRequest request){

        PageInfo pageInfo = staffOrderService.selectUserHistoryOrder(indexpage,hosermanid,3);
        request.setAttribute("pages",pageInfo);
        System.out.println(pageInfo.getList());
        return "/staff/staffHistoryOrder";
    }

}
