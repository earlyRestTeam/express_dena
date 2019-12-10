package com.example.express_dena.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("404error")
    public String error404(){
        return "/admin/404";
    }

    @RequestMapping("_header")
    public String _header(){
        return "/admin/_header";
    }
    
    
    @RequestMapping("admin_add")
    public String admin_add(){
        return "/admin/admin_add";
    }

    @RequestMapping("admin_list")
    public String admin_list(){
        return "/admin/admin_list";
    }

    @RequestMapping("admin_password_edit")
    public String admin_password_edit(){
        return "/admin/admin_password_edit";
    }

    @RequestMapping("admin_permission")
    public String admin_permission(){
        return "/admin/admin_permission";
    }

    @RequestMapping("admin_role")
    public String admin_role(){
        return "/admin/admin_role";
    }

    @RequestMapping("admin_role_add")
    public String admin_role_add(){
        return "/admin/admin_role_add";
    }

    @RequestMapping("article_list")
    public String article_list(){
        return "/admin/article_list";
    }

    @RequestMapping("change_password")
    public String change_password(){
        return "/admin/change_password";
    }


    @RequestMapping("feedback_list")
    public String feedback_list(){
        return "/admin/feedback_list";
    }

    @RequestMapping("index")
    public String index(){
        return "/admin/index";
    }

    @RequestMapping("member_add")
    public String member_add(){
        return "/admin/member_add";
    }



    @RequestMapping("member_del")
    public String member_del(){
        return "/admin/member_del";
    }

    @RequestMapping("member_list")
    public String member_list(){
        return "/admin/member_list";
    }

    @RequestMapping("picture_add")
    public String picture_add(){
        return "/admin/picture_add";
    }

    @RequestMapping("picture_list")
    public String picture_list(){
        return "/admin/picture_list";
    }

    @RequestMapping("picture_show")
    public String picture_show(){
        return "/admin/picture_show";
    }

    @RequestMapping("record_browse")
    public String record_browse(){
        return "/admin/record_browse";
    }

    @RequestMapping("record_download")
    public String record_download(){
        return "/admin/record_download";
    }

    @RequestMapping("record_share")
    public String record_share(){
        return "/admin/record_share";
    }

    @RequestMapping("user_add")
    public String user_add(){
        return "/admin/user_add";
    }

    @RequestMapping("user_list")
    public String user_list(){
        return "/admin/user_list";
    }

    @RequestMapping("user_password_edit")
    public String user_password_edit(){
        return "/admin/user_password_edit";
    }



    @RequestMapping("user_show")
    public String user_show(){
        return "/admin/user_show";
    }

    @RequestMapping("welcome")
    public String welcome(){
        return "/admin/welcome";
    }



}
