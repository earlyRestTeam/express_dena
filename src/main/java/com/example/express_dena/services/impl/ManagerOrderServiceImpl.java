package com.example.express_dena.services.impl;

import com.example.express_dena.mapper.OrderMapper;
import com.example.express_dena.pojo.Order;
import com.example.express_dena.pojo.OrderExample;
import com.example.express_dena.services.IManagerOrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ManagerOrderServiceImpl implements IManagerOrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public PageInfo selectOrder(Integer indexpage, String orderno, String username, String hosermanName) {
        if (orderno == null){
            orderno = "";
        }
        if (username == null){
            username = "";
        }
        if (hosermanName == null){
            hosermanName = "";
        }
        if (indexpage == null){
            indexpage = 1;
        }

        OrderExample example = new OrderExample();
        example.or().andOrdernoLike(orderno+"%")
                .andUsernameLike(username+"%")
                .andHosermanNameLike(hosermanName+"%");

        PageHelper.startPage(indexpage,10);
        List<Order> orders = orderMapper.selectByExample(example);
        PageInfo info = new PageInfo(orders,5);

        return info;
    }
}
