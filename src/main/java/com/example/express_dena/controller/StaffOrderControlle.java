package com.example.express_dena.controller;

import com.example.express_dena.pojo.Order;
import com.example.express_dena.services.impl.StaffOrderService;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping("/staff")
public class StaffOrderControlle {

    @Autowired
    StaffOrderService staffOrderService;
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

    //领取任务
    @RequestMapping("getOrder")
    public String getOrder(Integer id){


        boolean b = staffOrderService.pickupUserOrder(id);
        System.out.println("领取任务:" + b);

        return "redirect:/staff/staffGetOrder?indexpage=1";
    }

    //领取的订单列表
    @RequestMapping("staffGetOrder")
    public String staffGetOrdergList(Integer indexpage, HttpServletRequest request){


        System.out.println("indexpage:" + indexpage);
        Integer hosermanid = 1;
        Integer status = 2;
        PageInfo pageInfo = staffOrderService.selectUserOrder(indexpage,hosermanid,status);
        request.setAttribute("pages",pageInfo);
        System.out.println(pageInfo.getList());
        return "/staff/staffGetOrder";
    }

    //完成任务
    @RequestMapping("filishOrder")
    public String filishOrder(Integer id){
        if(staffOrderService.filishOrder(id)){
            return "redirect:/staff/staffGetOrder?indexpage=1";
        }
        return "redirect:/staff/staffGetOrder?indexpage=1&errey=0";

    }
    //历史订单界面
    @RequestMapping("staffHistoryOrder")
    public String staffHistoryOrder(Integer indexpage, HttpServletRequest request){
        Integer hosermanid = 1;
        Integer status = 3;
        PageInfo pageInfo = staffOrderService.selectUserHistoryOrder(indexpage,hosermanid,status);
        request.setAttribute("pages",pageInfo);
        System.out.println(pageInfo.getList());
        return "/staff/staffHistoryOrder";
    }

    //查询订单
    @RequestMapping("searchOrder")
    public String searchOrder(String orderno, HttpServletRequest request){
        PageInfo<Order> pageInfo = staffOrderService.searchOrderInfo(orderno);
        request.setAttribute("pages",pageInfo);
        return "/staff/staffHistoryOrder";

    }

}
