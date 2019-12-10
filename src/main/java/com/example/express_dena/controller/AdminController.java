package com.example.express_dena.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("404error")
    public String error404(){
        return "/404";
    }

    @RequestMapping("_header")
    public String _header(){
        return "/_header";
    }
    
    
    @RequestMapping("admin_add")
    public String admin_add(){
        return "/admin_add";
    }

    @RequestMapping("admin_list")
    public String admin_list(){
        return "/admin_list";
    }

    @RequestMapping("admin_password_edit")
    public String admin_password_edit(){
        return "/admin_password_edit";
    }

    @RequestMapping("admin_permission")
    public String admin_permission(){
        return "/admin_permission";
    }

    @RequestMapping("admin_role")
    public String admin_role(){
        return "/admin_role";
    }

    @RequestMapping("admin_role_add")
    public String admin_role_add(){
        return "/admin_role_add";
    }

    @RequestMapping("article_list")
    public String article_list(){
        return "/article_list";
    }

    @RequestMapping("change_password")
    public String change_password(){
        return "/change_password";
    }


    @RequestMapping("feedback_list")
    public String feedback_list(){
        return "/feedback_list";
    }

    @RequestMapping("index")
    public String index(){
        return "/index";
    }

    @RequestMapping("member_add")
    public String member_add(){
        return "/member_add";
    }



    @RequestMapping("member_del")
    public String member_del(){
        return "/member_del";
    }

    @RequestMapping("member_list")
    public String member_list(){
        return "/member_list";
    }

    @RequestMapping("picture_add")
    public String picture_add(){
        return "/picture_add";
    }

    @RequestMapping("picture_list")
    public String picture_list(){
        return "/picture_list";
    }

    @RequestMapping("picture_show")
    public String picture_show(){
        return "/picture_show";
    }

    @RequestMapping("record_browse")
    public String record_browse(){
        return "/record_browse";
    }

    @RequestMapping("record_download")
    public String record_download(){
        return "/record_download";
    }

    @RequestMapping("record_share")
    public String record_share(){
        return "/record_share";
    }

    @RequestMapping("user_add")
    public String user_add(){
        return "/user_add";
    }

    @RequestMapping("user_list")
    public String user_list(){
        return "/user_list";
    }

    @RequestMapping("user_password_edit")
    public String user_password_edit(){
        return "/user_password_edit";
    }



    @RequestMapping("user_show")
    public String user_show(){
        return "/user_show";
    }

    @RequestMapping("welcome")
    public String welcome(){
        return "/welcome";
    }



}
