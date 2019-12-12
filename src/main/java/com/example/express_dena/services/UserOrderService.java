package com.example.express_dena.services;

import com.example.express_dena.pojo.Order;
import com.example.express_dena.pojo.OrderExample;
import com.example.express_dena.pojo.Orderdetail;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * @author :Yang Jiahong
 * @date :2019/12/10 21:52
 */

public interface UserOrderService {

    //发布订单
    public Map<String,String> submitOrder(Order order, List<Orderdetail> orderdetails);

    //查询当前订单
    public PageInfo selectOrderCurrent(int userid,Integer indexpage);

    //查询历史已完成订单
    public PageInfo selectHistoryOrder(int userid,Integer indexpage);

    //删除历史订单
    public Map<String,String> deleteOrderByID(int orderid);

    //查询订单状态
    public int selectStatus(int orderid);

    //取消订单
    public Map<String,String> cancelOrderByID(int orderid);

    //查询订单详情
    public Map<String,String> selectOrderDetail(int orderid);

    //确认订单完成
    public Map<String,String> completeOrder(int Orderid);

    //评论
    public Map<String,String> comments(int userid,String contenr,int orderid,int hosemanid);

    /**
     * 查找 指定用户 指定状态 的 数量
     * @param userid
     * @param status
     * @return
     */
    int selectOrderCountByUseridAndOrderStatus(int userid,int status);



}
