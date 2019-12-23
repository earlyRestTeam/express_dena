package com.example.express_dena.util;

import com.example.express_dena.mapper.OrderMapper;
import com.example.express_dena.pojo.Order;
import com.example.express_dena.pojo.OrderExample;
import com.example.express_dena.pojo.OrderdetailExample;
import com.example.express_dena.services.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.thymeleaf.expression.Dates;

import java.util.Date;
import java.util.List;

@Component
public class Jobs {
    public final static long ONE_Minute =  60 * 1000;

    public final static long finsh = 60*1000;

    public final static long submit =60*1000;
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    UserOrderService service;


    @Scheduled(fixedDelay=ONE_Minute)
    public void fixedDelayJob(){

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andStatusEqualTo(5);
        List<Order> list = orderMapper.selectByExample(orderExample);
        if(list != null){
            for (int i = 0; i < list.size(); i++) {
                Order  order = list.get(i);
                if(order != null){
                    Date createTime = list.get(i).getCreateTime();
                    Date date = new Date();
                    if((date.getTime() - createTime.getTime()) > finsh){
                        order.setStatus(4);
                        orderMapper.updateByPrimaryKey(order);
                    }
                }
            }
        }
    }

    @Scheduled(fixedDelay=ONE_Minute)
    public void fixedDelayJob1(){
        OrderExample orderExample1 = new OrderExample();
        OrderExample.Criteria criteria1 = orderExample1.createCriteria();
        criteria1.andComfirmHosemanStatusEqualTo(1);
        criteria1.andStatusEqualTo(2);
        List<Order> list1 = orderMapper.selectByExample(orderExample1);
        if(list1 != null){
            for (int i = 0; i < list1.size(); i++) {
                Order  order = list1.get(i);
                if(order != null){
                    System.out.println(order.toString());
                    Date sendTime = list1.get(i).getSendTime();
                    Date date = new Date();
                    if((date.getTime() - sendTime.getTime()) > submit){
                        System.out.println(order.getId());
                        service.updateSysCompleteOrder(order.getId());
                    }
                }
            }
        }
    }

    @Scheduled(fixedRate=ONE_Minute)
    public void fixedRateJob(){
    }

    @Scheduled(cron="0 15 3 * * ?")
    public void cronJob(){
    }
}
