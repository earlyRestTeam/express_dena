package com.example.express_dena.services.impl;

import com.example.express_dena.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

    @Test
    void insert() {
        int res = userService.insert();

        System.out.println("res = " + res);

        assertNotEquals(0,res);
    }
}