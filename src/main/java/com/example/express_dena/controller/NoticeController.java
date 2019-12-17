package com.example.express_dena.controller;

import com.example.express_dena.pojo.Notice;
import com.example.express_dena.services.NoticeManageService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/admin/notice")
public class NoticeController {

    @Autowired
    NoticeManageService service;

    @RequestMapping("/index")
    public String  index(HttpServletRequest request,Integer indexpage,String keyword) {
        PageInfo pageInfo = service.queryNotice(indexpage,keyword);
        request.setAttribute("pages",pageInfo);
        request.setAttribute("keyword",keyword == null ? "" : keyword);
        return "/admin/picture-list";
    }

    @RequestMapping("/add")
    public String addNotice(Model model,Notice notice){

        Map<String, Object> stringObjectMap = service.addNotice(notice);
        model.addAttribute("notices",stringObjectMap);
        return "redirect:/admin/picture_list";
    }

    @RequestMapping("/update_notice")
    public String updateNotice(Notice notice){
        Map<String, Object> stringObjectMap = service.updateNotice(notice);
        return "redirect:/admin/picture_list";
    }

    @RequestMapping("/delete")
    public String deleteNotice(Notice notice){
        Map<String, Object> stringObjectMap = service.deleteNotice(notice);
        return "redirect:/admin/picture_list";
    }

    @RequestMapping("/batch_delete")
    public String batchDel(Integer[] ids){
        boolean b = service.deleteNotice(ids);
        return "redirect:/admin/picture_list";
    }
}
