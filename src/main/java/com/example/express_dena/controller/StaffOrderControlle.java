package com.example.express_dena.controller;

import com.example.express_dena.pojo.Horseman;
import com.example.express_dena.pojo.Order;
import com.example.express_dena.pojo.Orderdetail;
import com.example.express_dena.security.LoginEntityHelper;
import com.example.express_dena.services.impl.StaffOrderService;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffOrderControlle {

    @Autowired
    StaffOrderService staffOrderService;
    @Autowired
    LoginEntityHelper loginEntityHelper;
    //平台订单
    @RequestMapping("currentStaffOrder")
    public String currentStaffOrder(Integer indexpage, HttpServletRequest request){

        System.out.println("indexpage:" + indexpage);
        Integer status = 1;
        PageInfo pageInfo = staffOrderService.selectUserOrder(indexpage,status);
        request.setAttribute("pages",pageInfo);
        System.out.println(pageInfo.getList());
        if(indexpage!=null){
            return "/staff/currentStaffOrder::article_type";
        }
        return "/staff/currentStaffOrder";
    }
    //当订单详情页面
    @RequestMapping("orderetils")
    public String detailsOrder(Integer id,HttpServletRequest request){
        System.out.println("查看订单详情："+id);
        List<Orderdetail> orderdetails = staffOrderService.selectOrderdetail(id);
        PageInfo<Orderdetail> pageInfo = new PageInfo<>(orderdetails);
        request.setAttribute("pages",pageInfo);
        Order order = staffOrderService.selectOrderByOrderId(id);
        request.setAttribute("order",order);
        return "/staff/orderdetils";
    }

    //领取任务
    @RequestMapping("getOrder")
    public String getOrder(Integer id){


        boolean b = staffOrderService.updatePickupUserOrder(id);
        System.out.println("领取任务:" + b);
        if (b){
            return "redirect:/staff/staffGetOrder";
        }else {
            throw new RuntimeException("error");
        }

    }

    //领取的订单列表
    @RequestMapping("staffGetOrder")
    public String staffGetOrdergList(Integer indexpage, HttpServletRequest request){
        Horseman horseman = loginEntityHelper.getEntityByClass(Horseman.class);
        if(horseman==null){
            throw new RuntimeException("error");
        }
        System.out.println("indexpage:" + indexpage);
        Integer hosermanid = horseman.getId();
        Integer status = 2;
        PageInfo pageInfo = staffOrderService.selectUserOrder(indexpage,hosermanid,status);
        request.setAttribute("pages",pageInfo);
        System.out.println(pageInfo.getList());
        if(indexpage!=null){
            return "/staff/staffGetOrder::article_type";
        }
        return "/staff/staffGetOrder";
    }

    //完成任务
    @RequestMapping("filishOrder")
    public String filishOrder(Integer id){
        System.out.println("finishOrderid:" + id);
        Horseman horseman = loginEntityHelper.getEntityByClass(Horseman.class);
        if(horseman==null){
            throw new RuntimeException("error");
        }
        Integer hosermanid = horseman.getId();
        Integer status = 2;
        if(staffOrderService.updateFinishOrder(id,hosermanid,status)){
            return "redirect:/staff/staffGetOrder";
        }else {
            throw new RuntimeException("error");
        }


    }
    //历史订单界面
    @RequestMapping("staffHistoryOrder")
    public String staffHistoryOrder(Integer indexpage, HttpServletRequest request){
        Horseman horseman = loginEntityHelper.getEntityByClass(Horseman.class);
        if(horseman==null){
            throw new RuntimeException("error");
        }
        Integer hosermanid = horseman.getId();
        System.out.println("骑手id:" + hosermanid);
        Integer status = 3;
        Integer showHosemanStatus = 0;
        PageInfo pageInfo = staffOrderService.selectUserHistoryOrder(indexpage,hosermanid,status,showHosemanStatus);
        request.setAttribute("pages",pageInfo);
        System.out.println(pageInfo);
        if(indexpage!=null){
            return "/staff/staffHistoryOrder::article_type";
        }
        return "/staff/staffHistoryOrder";
    }

//    //历史订单界面局部刷新
//    @RequestMapping("refreshHistoryOrder")
//        public String refreshHistoryOrder(Integer indexpage, HttpServletRequest request){
//            Horseman horseman = loginEntityHelper.getEntityByClass(Horseman.class);
//            if(horseman==null){
//                throw new RuntimeException("error");
//            }
//            Integer hosermanid = horseman.getId();
//            System.out.println("骑手id:" + hosermanid);
//            Integer status = 3;
//            Integer showHosemanStatus = 0;
//            PageInfo pageInfo = staffOrderService.selectUserHistoryOrder(indexpage,hosermanid,status,showHosemanStatus);
//            request.setAttribute("pages",pageInfo);
//            System.out.println(pageInfo);
//            return "/staff/staffHistoryOrder::article_type";
//    }


    //查询未领取订单
    @RequestMapping("searchNoGetOrder")
    public String searchNoGetOrder(Integer indexpage,String orderno, HttpServletRequest request){
        System.out.println("orderno" + orderno);
        Integer status = 1;
        PageInfo<Order> pageInfo = staffOrderService.searchNoGetOrderInfo(indexpage,orderno,status);
        request.setAttribute("pages",pageInfo);
        return "/staff/currentStaffOrder::article_type";
    }

    //搜索已领取订单
    @RequestMapping("searchGetOrder")
    public String searchGetOrder(Integer indexpage,String orderno, HttpServletRequest request){
        System.out.println("搜索orderno:" + orderno);
        Integer status = 2;
        Integer hosermanid = 1;
        PageInfo<Order> pageInfo = staffOrderService.searchGetOrderInfo(indexpage,orderno,hosermanid,status);
        request.setAttribute("pages",pageInfo);
        return "/staff/staffGetOrder";
    }
    //搜索历史订单
    @RequestMapping("searchHistoryOrder")
    public String searchHistoryOrder(Integer indexpage,String orderno, HttpServletRequest request){
        System.out.println("orderno" + orderno);
        Integer hosermanid = 1;
        Integer status = 3;
        Integer showHosemanStatus = 0;
        PageInfo<Order> pageInfo = staffOrderService.searchHistoryOrder(indexpage,hosermanid,orderno,status,showHosemanStatus);
        request.setAttribute("pages",pageInfo);
        return "/staff/staffhistoryOrder";
    }
    //删除历史订单
    @RequestMapping("deleteHistoryOrder")
    public String deletehHistoryOrder(Integer id){
        System.out.println("删除:" + id);
        Integer hosermanid = 1;
        Integer status = 3;
        Integer showHosemanStatus = 0;
        if(staffOrderService.deleteStaffOrder(id,hosermanid,status,showHosemanStatus)){
            return "redirect:/staff/staffHistoryOrder";
        }else {
            throw new RuntimeException("error");
        }

    }
}
