package com.example.express_dena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 王志坚
 * @createTime 2019.12.10.20:25
 */
@Controller
public class PageController {

    @GetMapping("about_us")
    public String about_us(){
        return "/about_us";
    }
    @GetMapping("changePwd")
    public String changePwd(){
        return "/changePwd";
    }
    @GetMapping("currentUserOrder")
    public String currentUserOrder(){
        return "/currentUserOrder";
    }
    @GetMapping("detailsOrder")
    public String detailsOrder(){
        return "/detailsOrder";
    }
    @GetMapping({"index","/"})
    public String index(){
        return "/index";
    }
    @GetMapping("login")
    public String login(){
        return "/login";
    }
    @GetMapping("main")
    public String main(){
        return "/main";
    }
    @GetMapping("register")
    public String register(){
        return "/register";
    }
    @GetMapping("services")
    public String services(){
        return "/services";
    }
    @GetMapping("submitOrder")
    public String submitOrder(){
        return "/submitOrder";
    }
    @GetMapping("userApplication")
    public String userApplication(){
        return "/userApplication";
    }
    @GetMapping("userInfo")
    public String userInfo(){
        return "/userInfo";
    }
    @GetMapping("wallet")
    public String wallet(){
        return "/wallet";
    }
    @GetMapping("userHistoryOrder")
    public String userHistoryOrder(){
        return "/userHistoryOrder";
    }
}
