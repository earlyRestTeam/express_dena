package com.example.express_dena.services.impl;

import com.example.express_dena.mapper.OrderMapper;
import com.example.express_dena.pojo.Order;
import com.example.express_dena.pojo.OrderExample;
import com.example.express_dena.services.IManagerOrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @author 谢晓峰
 * @Classname ManagerOrderServiceImpl
 * @Description TODO
 * @Date 2019/12/11 10:46
 * @Version V1.0
 */
public class ManagerOrderServiceImpl implements IManagerOrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public PageInfo selectOrder(Integer indexpage, String orderno, String username, String hosermanName, Date createTimeMin, Date createTimeMax, Date endTimeMin, Date endTimeMax, Integer status) {
//        if (orderno == null){
//            orderno = "";
//        }
//        if (username == null){
//            username = "";
//        }
//        if (hosermanName == null){
//            hosermanName = "";
//        }

        OrderExample example = new OrderExample();
        example.or().andOrdernoLike(orderno+"%")
                .andUsernameLike(username+"%")
                .andHosermanNameLike(hosermanName+"%")
                .andCreateTimeBetween(createTimeMin,createTimeMax)
                .andEndTimeBetween(endTimeMin,endTimeMax)
                .andStatusEqualTo(status);

        List<Order> orders = orderMapper.selectByExample(example);

        PageHelper.startPage(indexpage,10);
        PageInfo info = new PageInfo(orders,5);

        return info;
    }
}
