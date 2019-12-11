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
        return "/admin/admin-add";
    }

    @RequestMapping("admin_list")
    public String admin_list(){
        return "/admin/admin-list";
    }

    @RequestMapping("admin_password_edit")
    public String admin_password_edit(){
        return "/admin/admin-password-edit";
    }

    @RequestMapping("admin_permission")
    public String admin_permission(){
        return "/admin/admin-permission";
    }

    @RequestMapping("admin_role")
    public String admin_role(){
        return "/admin/admin-role";
    }

    @RequestMapping("admin_role_add")
    public String admin_role_add(){
        return "/admin/admin-role-add";
    }

    @RequestMapping("article_list")
    public String article_list(){
        return "/admin/article-list";
    }

    @RequestMapping("change_password")
    public String change_password(){
        return "/admin/change-password";
    }


    @RequestMapping("feedback_list")
    public String feedback_list(){
        return "/admin/feedback-list";
    }

    @RequestMapping("index")
    public String index(){
        return "/admin/index";
    }

    @RequestMapping("member_add")
    public String member_add(){
        return "/admin/member-add";
    }



    @RequestMapping("member_del")
    public String member_del(){
        return "/admin/member-del";
    }

    @RequestMapping("member_list")
    public String member_list(){
        return "/admin/member-list";
    }

    @RequestMapping("picture_add")
    public String picture_add(){
        return "/admin/picture-add";
    }

    @RequestMapping("picture_list")
    public String picture_list(){
        return "/admin/picture-list";
    }

    @RequestMapping("picture_show")
    public String picture_show(){
        return "/admin/picture-show";
    }

    @RequestMapping("record_browse")
    public String record_browse(){
        return "/admin/record-browse";
    }

    @RequestMapping("record_download")
    public String record_download(){
        return "/admin/record-download";
    }

    @RequestMapping("record_share")
    public String record_share(){
        return "/admin/record-share";
    }

    @RequestMapping("user_add")
    public String user_add(){
        return "/admin/user-add";
    }

    @RequestMapping("user_list")
    public String user_list(){
        return "/admin/user-list";
    }

    @RequestMapping("user_password_edit")
    public String user_password_edit(){
        return "/admin/user-password-edit";
    }



    @RequestMapping("user_show")
    public String user_show(){
        return "/admin/user-show";
    }

    @RequestMapping("welcome")
    public String welcome(){
        return "/admin/welcome";
    }



}
