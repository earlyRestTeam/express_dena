package com.example.express_dena.controller;

import com.example.express_dena.mapper.MessageMapper;
import com.example.express_dena.pojo.Horseman;
import com.example.express_dena.pojo.Message;
import com.example.express_dena.pojo.User;
import com.example.express_dena.security.LoginEntityHelper;
import com.example.express_dena.services.IMessageService;
import com.example.express_dena.services.UserService;
import com.example.express_dena.services.impl.MessageService;
import com.example.express_dena.services.impl.StaffService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {
    @Autowired
    UserService userService;
    @Autowired
    IMessageService messageService;
    @Autowired
    LoginEntityHelper loginEntityHelper;
    @Autowired
    StaffService staffService;


    @GetMapping("/logout/success")
    public String logout(){
        return "/index";
    }
    @GetMapping("about_us")
    public String about_us(){
        return "/about_us";
    }
    @GetMapping("findBackPage")
    public String findBackPage(){
        return "/findBack";
    }
    @GetMapping("/staff/wallet")
    public String wallet(Model model){
        Horseman horseman = loginEntityHelper.getEntityByClass(Horseman.class);
        if(horseman==null){
            throw new RuntimeException("error");
        }

        Integer hosermanid = horseman.getId();
        horseman = staffService.selectHorseman(hosermanid);
        model.addAttribute("balance",horseman.getBalance());
        return "/staff/wallet";
    }
    @GetMapping({"index","/"})
    public String index(){
        return "/index";
    }

    @GetMapping("register")
    public String register(){
        return "/register";
    }
    @GetMapping("services")
    public String services(){
        return "/services";
    }
}
