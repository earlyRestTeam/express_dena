package com.example.express_dena.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.express_dena.pojo.Horseman;
import com.example.express_dena.pojo.Message;
import com.example.express_dena.pojo.User;
import com.example.express_dena.security.LoginEntityHelper;
import com.example.express_dena.services.impl.MessageService;
import com.example.express_dena.services.impl.StaffOrderService;
import com.example.express_dena.services.impl.StaffService;
import com.example.express_dena.util.APIResult;
import com.example.express_dena.util.StaticPool;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author :Yang Jiahong
 * @date :2019/12/10 20:58
 */
@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    StaffOrderService staffOrderService;

    @Autowired
    StaffService staffService;
    @Autowired
    MessageService messageService;

    @Autowired
    LoginEntityHelper loginEntityHelper;
    //登录页面跳转
    @RequestMapping("login")
    public String stafflogin(Model m){
        m.addAttribute("type", StaticPool.STAFF);
        return "/login";
    }

    //注册界面跳转
    @RequestMapping("register")
    public String staffRegister(){
        return "/register";
    }

    //快递员主界面
    @RequestMapping("staffmain")
    public String staffMain(HttpServletRequest request){
        Horseman horseman = loginEntityHelper.getEntityByClass(Horseman.class);
        if(horseman==null){
            throw new RuntimeException("error");
        }

        Integer hosermanid = horseman.getId();

        Horseman horseman1 = staffService.selectHorseman(hosermanid);
        Integer status = 3;
        long finishOrderNum = staffOrderService.selectFinishOrderNum(1,hosermanid,status);

        request.setAttribute("finishOrderNum",finishOrderNum);
        request.setAttribute("horseman",horseman1);

        return "/staff/staffmain";

    }

    //快递员钱包界面跳转
    @RequestMapping("staffwallet")
    public String staffWaller(){
        return "/staff/staffwallet";
    }

    //快递员个人信息
    @RequestMapping("staffinfo")
    public String staffInfo(HttpServletRequest request){

        return "redirect:/staff/staffmain";
//        return "/staff/staffmain";
    }

    @RequestMapping("staffchangePwd")
    public String staffInfo(){

        return "staff/staffchangePwd";
    }


    //更改密码界面
    @ResponseBody
    @RequestMapping("changeHorsemanPwd")
    public APIResult staffchangePwd(@RequestBody JSONObject jsonObject){

        Horseman horseman = loginEntityHelper.getEntityByClass(Horseman.class);
        if ( horseman == null )
            throw new RuntimeException("error");

        APIResult result = null;

        String oldPassword = (String) jsonObject.get("oldPassword");

        String newPassword = (String) jsonObject.get("newPassword");

        if(StringUtils.isEmpty(oldPassword) || StringUtils.isEmpty(newPassword)){
            result =  APIResult.genFailApiResponse("PARAMS ERROR!");
            return result;
        }

        Map<String, String> res = staffService.updateChangePassword(horseman.getId(), oldPassword, newPassword);

        if( res.get(StaticPool.ERROR) != null ){
            result = APIResult.genFailApiResponse(res.get(StaticPool.ERROR));
        }else {
            result = APIResult.genSuccessApiResponse(res.get(StaticPool.SUCCESS));
        }
        return result;
    }

    /**
     * 修改资料
     */
    @ResponseBody
    @RequestMapping("update")
    public APIResult updateHorseman(@RequestBody Horseman horseman,HttpServletRequest request){
        Horseman horseman1 = loginEntityHelper.getEntityByClass(Horseman.class);
        if ( horseman1 == null )
            throw new RuntimeException("error");

        horseman.setId(horseman1.getId());
        APIResult result = null;
        Map<String, String> res = staffService.updateUserInfo(horseman);
        if( res.get(StaticPool.ERROR) != null ){
            result = APIResult.genFailApiResponse(res.get(StaticPool.ERROR));
        }else {
            result = APIResult.genSuccessApiResponse(res.get(StaticPool.SUCCESS));
        }
        return result;

    }

    /**
     * 骑手消息
     */
    @RequestMapping("staffMessage")
    public String staffMessage(Integer indexpage, HttpServletRequest request){
        Horseman horseman = loginEntityHelper.getEntityByClass(Horseman.class);

        if ( horseman == null )
            throw new RuntimeException("error");

        Integer horsemanid = horseman.getId();
        PageInfo<Message> messagePageInfo = messageService.queryMessage(horsemanid, 2, indexpage, 3);
        request.setAttribute("pages",messagePageInfo);
        System.out.println(messagePageInfo);

        if(indexpage!=null){
            return "/staff/staffMessage::article_type";
        }
        return "/staff/staffMessage";
    }

    /**
     * 骑手读取消息
     */
    @RequestMapping("readMessage")
    public String readMessage(Integer messageId) {
        if (messageService.updateReadMessage(messageId)) {
            return "redirect:/staff/staffMessage";
        } else {
            throw new RuntimeException("error");
        }
    }
}
