package com.example.express_dena.services.impl;

import com.example.express_dena.mapper.UserMapper;
import com.example.express_dena.pojo.User;
import com.example.express_dena.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author :Yang Jiahong
 * @date :2019/12/10 15:12
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public int insert() {

        User u   = new User();
        u.setUsername("hello");
        u.setAccount("123");
        u.setPassword("123");

        int id = userMapper.insert(u);
        return id;
    }
}
