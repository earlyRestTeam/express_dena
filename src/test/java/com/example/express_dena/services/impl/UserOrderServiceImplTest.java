package com.example.express_dena.services.impl;

import com.example.express_dena.pojo.Order;
import com.example.express_dena.services.UserOrderService;
import com.example.express_dena.util.StaticPool;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class UserOrderServiceImplTest {

    @Autowired
    UserOrderService userOrderService;

    @Test
    void selectOrderCurrent() {
        PageInfo info = userOrderService.selectOrderCurrent(1,null);
        if(info ==null){
            System.out.println("ssss");
        }
        System.out.println(info.toString());
    }

    @Test
    void cancelOrderByID() {
        Map map = userOrderService.cancelOrderByID(1);
        if(map.get(StaticPool.SUCCESS) ==null){
            System.out.println(map.get(StaticPool.SUCCESS));
        }else{
            System.out.println(map.get(StaticPool.SUCCESS));
        }
    }

}