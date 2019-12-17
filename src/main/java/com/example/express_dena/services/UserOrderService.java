package com.example.express_dena.services;

import com.example.express_dena.pojo.Comment;
import com.example.express_dena.pojo.Order;
import com.example.express_dena.pojo.OrderExample;
import com.example.express_dena.pojo.Orderdetail;
import com.example.express_dena.util.PayException;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface UserOrderService {

    //发布订单
    public Map<String,String> insertOrder(Order order, List<Orderdetail> orderdetails);

    //查询当前订单
    public PageInfo selectOrderCurrent(int userid, Integer indexpage,String serchid);

    //查询历史已完成订单
    public PageInfo selectHistoryOrder(int userid, Integer indexpage,String serchid);

    //根据orderid查询订单信息
    public Order selectOrderById(int orderid);

    //根据orderid查询该订单的所有包裹详情
    public List<Orderdetail> selectOrderdetailById(int orderid);

    //删除历史订单
    public Map<String,String> deleteUserOrderByID(int orderid);

    //查询订单状态
    public int selectStatus(int orderid);

    //取消订单
    public Map<String,String> updateCancelOrderByID(int orderid) throws PayException;

    //查询订单详情
    public Map<String,String> selectOrderDetail(int orderid);

    //确认订单完成
    public Map<String,String> updateCompleteOrder(int Orderid);

    //添加评论
    public Map<String,String> insertComments(Comment comment);

    /**
     * 查找 指定用户 指定状态 的 数量
     * @param userid
     * @param status
     * @return
     */
    int selectOrderCountByUseridAndOrderStatus(int userid,int status);

    //根据订单编号查询订单
    public Order selecteOrderByNO(String orderno);

    //是未支付订单状态变为未结单
    public int updatePickOrder(int orderid);



}
