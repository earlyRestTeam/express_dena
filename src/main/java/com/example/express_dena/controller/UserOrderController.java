package com.example.express_dena.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.example.express_dena.pojo.*;
import com.example.express_dena.security.LoginEntityHelper;
import com.example.express_dena.services.IAliPayService;
import com.example.express_dena.services.IMessageService;
import com.example.express_dena.services.UserOrderService;
import com.example.express_dena.util.APIResult;
import com.example.express_dena.util.PayException;
import com.example.express_dena.util.StaticPool;
import com.github.pagehelper.PageInfo;
import com.sun.corba.se.spi.presentation.rmi.IDLNameTranslator;
import com.sun.org.apache.regexp.internal.RE;
import jdk.nashorn.internal.runtime.regexp.joni.Config;
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
import java.util.logging.Logger;


@Controller
@RequestMapping("/user")
public class UserOrderController {

    @Autowired
    UserOrderService service;

    @Autowired
    IAliPayService iAliPayService;


    @Autowired
    IMessageService iMessageService;


    //查看用户当前订单
    @RequestMapping("currentUserOrder")
    public String selectOrderCurrent(Integer indexpage, HttpServletRequest request,String serchid){
        LoginEntityHelper loginEntityHelper = new LoginEntityHelper();
        User user =loginEntityHelper.getEntityByClass(User.class);
        PageInfo info = service.selectOrderCurrent(user.getId(),indexpage,serchid);
        request.setAttribute("serchid",serchid);
        request.setAttribute("pages",info);
        return "/currentUserOrder";
    }

    //查看用户历史订单(订单号或接单员为空则为全部)
    @RequestMapping("userHistoryOrder")
    public String selectuserHistoryOrder(Integer indexpage, HttpServletRequest request,String serchid){
        LoginEntityHelper loginEntityHelper = new LoginEntityHelper();
        User user =loginEntityHelper.getEntityByClass(User.class);
        PageInfo info = service.selectHistoryOrder(user.getId(),indexpage,serchid);
        request.setAttribute("serchid",serchid);
        request.setAttribute("pages",info);
        return "/userHistoryOrder";
    }

    //提交订单页面
    @RequestMapping("submitOrder")
    public String selectsubmitOrder(){
        return "/submitOrder";
    }

    //前往支付页面
    @RequestMapping("returnpayOrder")
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
        String username = (String) jsonObject.get("username");
        Order order = new Order();
        order.setTotalAmount(Float.parseFloat(totalAmount));
        order.setPickUpAddress(pickUpAddress);
        order.setUserTelephone(userTelephone);
        order.setNote(note);
        order.setOrderno(orderno);
        order.setTargetAddress(targetAddress);
        order.setUsername(username);

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
    public String returnusrl(HttpServletRequest request){
          String orderno = request.getParameter("out_trade_no");
          Order order = service.selecteOrderByNO(orderno);
        if(iAliPayService.checkAlipay(orderno)) {
            int count = 3;
            int result = service.updatePickOrder(order.getId());
            while (result == 0 && count-- > 0) {
                result = service.updatePickOrder(order.getId());
            }
            if (result > 0) {
                return "redirect:/user/currentUserOrder";
            }else{
                try {
                    iAliPayService.refund(orderno,order.getTotalAmount().toString());
                    return "redirect:/user/submitOrder";
                } catch (AlipayApiException e) {
                    e.printStackTrace();
                }
            }
        }
        return "redirect:/user/currentUserOrder";
    }

    //取消订单
    @RequestMapping("cancelOrderByID")
    @ResponseBody
    public APIResult updateCancelOrderByID(@RequestBody JSONObject jsonObject){
        Integer orderid = (Integer) jsonObject.get("orderid");
        try{
            Map<String,String> map =  service.updateCancelOrderByID(orderid);
            return APIResult.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        }catch (PayException e){
            System.out.println("e.getMessage() = " + e.getMessage());
            APIResult apiResult = APIResult.genFailApiResponse(e.getMessage());
//            Logger.error("reback error");
            return apiResult;
        }
    }

    //确认订单完成订单
    @RequestMapping("completeOrder")
    @ResponseBody
    public APIResult updateCompleteOrder(@RequestBody JSONObject jsonObject){
        Integer orderid = (Integer) jsonObject.get("orderid");
        try{
            Map<String,String> map =  service.updateCompleteOrder(orderid);
            return APIResult.genSuccessApiResponse(map.get(StaticPool.SUCCESS));
        } catch (PayException e){
            System.out.println("e.getMessage() = " + e.getMessage());
            APIResult apiResult = APIResult.genFailApiResponse(e.getMessage());
//            Logger.error("reback error");
            return apiResult;
        }
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

    //查看订单详情
    @RequestMapping("checkOrderDetail")
    public String checkOrderDetail(Integer orderid, HttpServletRequest request){
       /* Integer orderid = (Integer) jsonObject.get("orderid");*/
        Order order = service.selectOrderById(orderid);
        List<Orderdetail> list = service.selectOrderdetailById(orderid);
        request.setAttribute("order",order);
        request.setAttribute("orderdetail",list);
        return "orderdetils";
    }

    //查看订单详情
    @RequestMapping("tocomments")
    public String tocomments(Integer orderid, HttpServletRequest request){
        request.setAttribute("orderid",orderid);
        return "comments";
    }

    @RequestMapping("submitcomments")
    @ResponseBody
    public APIResult submitcomments(@RequestBody JSONObject jsonObject,HttpServletRequest request){
        String orderid = (String) jsonObject.get("orderid");
        String comments = (String) jsonObject.get("comments");
        System.out.println("orderid"+orderid);
        System.out.println("comments"+comments);
        Order order = service.selectOrderById(Integer.parseInt(orderid));

        int userid = order.getUserid();
        int hosermanid = order.getHosermanid();

        Comment comment = new Comment();
        comment.setContent(comments);
        comment.setCreateTime(new Date());
        comment.setHorsemanId(hosermanid);
        comment.setOrderId(Integer.parseInt(orderid));
        comment.setStatus((byte) 1);
        comment.setUserId(userid);
        Map<String,String> map = service.insertComments(comment);
        APIResult apiResult = new APIResult();
        apiResult.setData(map);
        return apiResult;
    }
}
