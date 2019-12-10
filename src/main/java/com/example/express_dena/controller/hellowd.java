package com.example.express_dena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :Yang Jiahong
 * @date :2019/12/10 15:13
 */

@RestController
public class hellowd {

    @RequestMapping("/hellow")
    public String test(){
        return "index";
    }

}
