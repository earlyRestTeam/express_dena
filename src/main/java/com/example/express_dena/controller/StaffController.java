package com.example.express_dena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author :Yang Jiahong
 * @date :2019/12/10 20:58
 */
@Controller
@RequestMapping("/staff")
public class StaffController {

    //登录页面跳转
    @RequestMapping("login")
    public String stafflogin(){
        return "/login";
    }

    //注册界面跳转
    @RequestMapping("register")
    public String staffRegister(){
        return "/register";
    }

    //快递员钱主界面
    @RequestMapping("staffmain")
    public String staffMain(){
        return "/staff/staffmain";
    }

    //快递员钱包界面跳转
    @RequestMapping("staffwallet")
    public String staffWaller(){
        return "/staff/staffwallet";
    }

    //快递员个人信息
    @RequestMapping("staffinfo")
    public String staffInfo(){
        return "/staff/staffinfo";
    }


    //更改密码界面
    @RequestMapping("staffchangePwd")
    public String staffchangePwd(){
        return "/staff/staffchangePwd";
    }





}
