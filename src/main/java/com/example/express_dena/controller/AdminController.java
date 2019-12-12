package com.example.express_dena.controller;


import com.example.express_dena.services.impl.AdminServiceimpl;
import com.example.express_dena.util.StaticPool;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminServiceimpl adminServiceimpl;

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("type", StaticPool.ADMIN);
        return "/login";
    }
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


    /**
     * 查询用户(状态为1正在使用的）
     * @param request
     * @param indexpage
     * @param serchname
     * @return
     */
    @RequestMapping("member_list")
    public String member_list(HttpServletRequest request, Integer indexpage, String serchname){
        PageInfo pageInfo = adminServiceimpl.selectUsers(indexpage, serchname);
        request.setAttribute("pages",pageInfo);
        request.setAttribute("serchname",serchname);
        return "/admin/member-list";
    }

    /**
     * 查询用户(状态为-1被冻结的）
     * @param request
     * @param indexpage
     * @param serchname
     * @return
     */
    @RequestMapping("member_list_stop")
    public String member_list_stop(HttpServletRequest request, Integer indexpage, String serchname){
        PageInfo pageInfo = adminServiceimpl.selectUsersStop(indexpage, serchname);
        request.setAttribute("pages",pageInfo);
        request.setAttribute("serchname",serchname);
        return "/admin/member-del";
    }

    /**
     * 冻结用户
     * @param userid
     * @return
     */
    @RequestMapping("member_list_frozenuser")
    public String member_list_frozenuser(Integer userid){
        adminServiceimpl.forzenUser(userid);
        return "redirect:/admin/member_list";
    }

    /**
     * 启用用户
     * @param userid
     * @return
     */
    @RequestMapping("member_list_startuser")
    public String member_list_startuser(Integer userid){
        adminServiceimpl.startUser(userid);
        return "redirect:/admin/member_list_stop";
    }

    /**
     * 查询骑手(状态为1正在使用的）
     * @param request
     * @param indexpage
     * @param serchname
     * @return
     */
    @RequestMapping("horseman_list")
    public String horseman_list(HttpServletRequest request, Integer indexpage, String serchname){
        PageInfo pageInfo = adminServiceimpl.selectHorseman(indexpage, serchname);
        request.setAttribute("pages",pageInfo);
        request.setAttribute("serchname",serchname);
        return "/admin/horseman-list";
    }

    /**
     * 查询骑手(状态为-1被冻结的）
     * @param request
     * @param indexpage
     * @param serchname
     * @return
     */
    @RequestMapping("horseman_list_stop")
    public String horseman_list_stop(HttpServletRequest request, Integer indexpage, String serchname){
        PageInfo pageInfo = adminServiceimpl.selectHorsemanStop(indexpage, serchname);
        request.setAttribute("pages",pageInfo);
        request.setAttribute("serchname",serchname);
        return "/admin/horseman-del";
    }

    /**
     * 冻结骑手
     * @param horsemanid
     * @return
     */
    @RequestMapping("horseman_list_frozenuser")
    public String horseman_list_frozenuser(Integer horsemanid){
        adminServiceimpl.forzenHorseman(horsemanid);
        return "redirect:/admin/horseman_list";
    }

    /**
     * 启用骑手
     * @param horsemanid
     * @return
     */
    @RequestMapping("horseman_list_startuser")
    public String horseman_list_startuser(Integer horsemanid){
        adminServiceimpl.startHorseman(horsemanid);
        return "redirect:/admin/horseman_list_stop";
    }

    /**
     * 显示申请骑手审核列表即所有状态的骑手
     * @param request
     * @param indexpage
     * @param serchname
     * @return
     */
    @RequestMapping("article_list")
    public String article_list(HttpServletRequest request, Integer indexpage, String serchname){
        PageInfo pageInfo = adminServiceimpl.selectAllHorseman(indexpage, serchname);
        request.setAttribute("pages",pageInfo);
        request.setAttribute("serchname",serchname);
        System.out.println(pageInfo);
        return "/admin/article-list";
    }
    @RequestMapping("checked_apply")
    public String checked_apply(Integer horsemanid,Byte status){
        adminServiceimpl.checked_apply(horsemanid,status);
        return "redirect:/admin/article_list";
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
