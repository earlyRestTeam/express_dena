package com.example.express_dena.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.express_dena.pojo.Message;
import com.example.express_dena.pojo.Order;
import com.example.express_dena.pojo.Orderdetail;
import com.example.express_dena.services.IAliPayService;
import com.example.express_dena.services.UserOrderService;
import com.example.express_dena.util.APIResult;
import com.example.express_dena.util.StaticPool;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author :Yang Jiahong
 * @date :2019/12/11 16:03
 */
@Controller
public class UserOrderController {

    @Autowired
    UserOrderService service;

    @Autowired
    IAliPayService iAliPayService;


    //查看用户当前订单
    @RequestMapping("currentUserOrder")
    public String selectOrderCurrent(Integer indexpage, HttpServletRequest request){
        int userid = 1;
        PageInfo info = service.selectOrderCurrent(userid,indexpage);
        request.setAttribute("page",info);
        return "/currentUserOrder";
    }

    //查看用户历史订单
    @RequestMapping("userHistoryOrder")
    public String selectuserHistoryOrder(Integer indexpage, HttpServletRequest request){
        int userid = 1;
        PageInfo info = service.selectHistoryOrder(userid,indexpage);
        request.setAttribute("page",info);
        return "/userHistoryOrder";
    }

    //提交订单页面
    @RequestMapping("submitOrder")
    public String selectsubmitOrder(){
        return "/submitOrder";
    }

    //前往支付页面
    @RequestMapping("payOrder")
    public String returnpayOrder(HttpServletRequest request,Order order,String[] message,
                                 String identityaddress,String cityaddress,
                                 String areaaddress,String streetaddress){
        String[] message1 = message;
        List<Orderdetail> orderdetails = new ArrayList<>();
        for (int i = 0; i < message1.length; i++) {
            Orderdetail orderdetail = new Orderdetail();
            orderdetail.setPickUpCode(message1[i]);
            orderdetails.add(orderdetail);
        }
        String address = identityaddress+cityaddress+areaaddress+streetaddress+order.getPickUpAddress();
        String targetAddress = identityaddress+cityaddress+areaaddress+streetaddress+order.getTargetAddress();
        order.setPickUpAddress(address);
        order.setTargetAddress(targetAddress);
        request.setAttribute("orderdetails",orderdetails);
        request.setAttribute("order",order);
        return "/payOrder";
    }


    //提交订单
    @RequestMapping("insertorder")
    @ResponseBody
    public APIResult paySuccessfull(@RequestBody JSONObject jsonObject, HttpServletRequest request){
        String totalAmount = (String) jsonObject.get("totalAmount");
        List<String> messagelist = (List<String>) jsonObject.get("message");
        List<String> kglist = (List<String>) jsonObject.get("kg");
        String pickUpAddress = (String) jsonObject.get("pickUpAddress");
        String userTelephone = (String) jsonObject.get("userTelephone");
        String note = (String) jsonObject.get("note");
        String targetAddress = (String) jsonObject.get("targetAddress");
        String orderno = UUID.randomUUID().toString().replaceAll("-","");
        Order order = new Order();
        order.setTotalAmount(Float.parseFloat(totalAmount));
        order.setPickUpAddress(pickUpAddress);
        order.setUserTelephone(userTelephone);
        order.setNote(note);
        order.setOrderno(orderno);
        order.setTargetAddress(targetAddress);

        Map<String, Object> returnresult = new HashMap<>();
        returnresult.put("totalAmount",totalAmount);
        returnresult.put("orderno",orderno);
        List<Orderdetail> orderdetails = new ArrayList<>();
        for (int i = 0; i < messagelist.size(); i++) {
            Orderdetail orderdetail = new Orderdetail();
            orderdetail.setPickUpCode(messagelist.get(i));
            orderdetail.setKg(Float.parseFloat(kglist.get(i)));
            orderdetails.add(orderdetail);
        }
        Map<String, String> submitresult = service.insertOrder(order,orderdetails);
        APIResult apiResult = new APIResult();
        if(submitresult.get(StaticPool.SUCCESS) != null){
            returnresult.put("flag",1);
        }else{
            returnresult.put("flag",-1);
        }

        apiResult.setData(returnresult);
        return apiResult;
    }

    //前往支付页面
    @RequestMapping("topay")
    public void payorder(String totalAmount, String orderno, HttpServletResponse httpResponse) throws IOException {

        String form = iAliPayService.genPage(totalAmount,orderno);
        httpResponse.setContentType("text/html;charset=" + "utf8");
        httpResponse.getWriter().write(form);//直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    //支付成功后返回
    @RequestMapping("returnUrl")
    public String returnusrl(){
        System.out.println("支付");
          return "submitOrder";
    }

    //取消订单
    @RequestMapping("cancelOrderByID")
    @ResponseBody
    public APIResult updateCancelOrderByID(@RequestBody JSONObject jsonObject){
        Integer orderid = (Integer) jsonObject.get("orderid");
        Map<String,String> map =  service.updateCancelOrderByID(orderid);
        APIResult apiResult = new APIResult();
        apiResult.setData(map);
        return apiResult;
    }

    //确认订单完成订单
    @RequestMapping("completeOrder")
    @ResponseBody
    public APIResult updateCompleteOrder(@RequestBody JSONObject jsonObject){
        Integer orderid = (Integer) jsonObject.get("orderid");
        Map<String,String> map =  service.deleteUserOrderByID(orderid);
        APIResult apiResult = new APIResult();
        apiResult.setData(map);
        return apiResult;
    }


    //删除用户历史订单
    @RequestMapping("deleteUserOrder")
    @ResponseBody
    public APIResult deleteUserOrder(@RequestBody JSONObject jsonObject){
        Integer orderid = (Integer) jsonObject.get("orderid");
        Map<String,String> map =  service.deleteUserOrderByID(orderid);
        APIResult apiResult = new APIResult();
        apiResult.setData(map);
        return apiResult;
    }

}
