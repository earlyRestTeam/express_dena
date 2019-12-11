package com.example.express_dena.services.impl;

import com.example.express_dena.pojo.Horseman;
import com.example.express_dena.pojo.User;
import com.example.express_dena.services.UserService;
import com.example.express_dena.util.StaticPool;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 王志坚
 * @createTime 2019.12.10.17:31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserService userService;

//    @Test
//    void insert() {
//        int res = userService.insert();
//
//        System.out.println("res = " + res);
//
//        assertNotEquals(0,res);
//    }
    @Test
    void register() {
        User u = new User();
        u.setPassword("123");

        u.setAccount( ""+(Math.random()*100) );
        u.setUsername( (""+(Math.random()*100)).substring(0,6) );
        u.setEmail(""+(Math.random()*100));
        u.setAccount( (""+(Math.random()*100) ).substring(0,6));
        u.setCreateTime(new Date());

        Map<String, String> res = userService.register(u);

        String str = res.get(StaticPool.SUCCESS);
        assertNotNull(str);
    }
    @Test
    void updateUserInfo() {
        User u = new User();
        u.setId(1);
        u.setPhone("123");
        Map<String, String> res = userService.updateUserInfo(u);
        String str = res.get(StaticPool.SUCCESS);
        assertNotNull(str);

    }
    @Test
    void changePassword() {
        Map<String, String> res = userService.changePassword(1, "123", "345");
        String str = res.get(StaticPool.SUCCESS);
        assertNotNull(str);
    }
    @Test
    void forgetPassword() {
        Map<String, String> res = userService.forgetPassword("123", "123", "123", "123");
        String str = res.get(StaticPool.SUCCESS);
        System.out.println("str = " + str);
        assertNotNull(str);
    }
    @Test
    void applicationStaff() {
        Horseman horseman = new Horseman();
        horseman.setIdCard(""+(Math.random()*100) );
        horseman.setAccount((""+(Math.random()*100) ).substring(0,6) );
        horseman.setCreateTime(new Date());
        horseman.setEmail(""+(Math.random()*100) );
        horseman.setIdCardPicBack(""+(Math.random()*100) );
        horseman.setIdCardPicPre(""+(Math.random()*100) );

        Map<String, String> res = userService.applicationStaff(horseman);
        String str = res.get(StaticPool.SUCCESS);
        System.out.println("str = " + str);
        assertNotNull(str);
    }
//    @Test
//    void recharge() {
//        int res = userService.insert();
//
//        System.out.println("res = " + res);
//
//        assertNotEquals(0,res);
//    }
//    @Test
//    void feedBack() {
//        int res = userService.insert();
//
//        System.out.println("res = " + res);
//
//        assertNotEquals(0,res);
//    }
}