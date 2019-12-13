package com.example.express_dena.controller;

import com.example.express_dena.pojo.Message;
import com.example.express_dena.pojo.User;
import com.example.express_dena.security.LoginEntityHelper;
import com.example.express_dena.services.IMessageService;
import com.example.express_dena.services.UserOrderService;
import com.example.express_dena.services.UserService;
import com.example.express_dena.util.StaticPool;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



/**
 * @author 王志坚
 * @createTime 2019.12.11.10:26
 */
@Controller
@RequestMapping("/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;
    @Autowired
    IMessageService messageService;
    @Autowired
    LoginEntityHelper loginEntityHelper;
    @Autowired
    UserOrderService userOrderService;

    /**
     * 用户登录
     * @param m
     * @return
     */
    @GetMapping("/login")
    public String login(Model m){
        m.addAttribute("type", StaticPool.USER);
        return "/login";
    }
    @GetMapping("changePwd")
    public String changePwd(){
        return "/changePwd";
    }
    @GetMapping("main")
    public String main(){
        return "redirect:userInfo";
    }
    @GetMapping("userApplication")
    public String userApplication(){
        return "/userApplication";
    }

    /**
     * 获取个人信息
     * @param m
     * @return
     */
    @GetMapping("userInfo")
    public String userInfo(Model m){
        logger.info("user look info ");
        User user = loginEntityHelper.getEntityByClass(User.class);
        if ( user == null ){
            logger.error("login entity is null !");
            throw new RuntimeException("error");
        }

        int count = userOrderService.selectOrderCountByUseridAndOrderStatus(user.getId(), StaticPool.ORDER_SUCCESS);

        //无法保证登录之后个人信息 有无修改 -- 重新 查一次 数据库
        user = userService.selectByUserId(user.getId());
        m.addAttribute("user",user);
        m.addAttribute("count",count);
        return "/userInfo";
    }
    @GetMapping("wallet")
    public String wallet(){
        return "/wallet";
    }
    @GetMapping("findBack")
    public String findBack(){
        return "/findBack";
    }

    /**
     * 加载个人信息
     * @param index
     * @param size
     * @param model
     * @return
     */
    @GetMapping("/user/message")
    public String message(@RequestParam(value = "index",defaultValue = "1")int index
            ,@RequestParam(value = "size",defaultValue = "8")int size,Model model){
        User user = loginEntityHelper.getEntityByClass(User.class);
        if ( user == null ){
            logger.error("login entity is null !");
            throw new RuntimeException("error");
        }

        PageInfo<Message> pageInfo = messageService.queryMessage(user.getId(),StaticPool.USER_ENTITY,index,size);
        model.addAttribute("pageResult",pageInfo);
        return "/message";
    }
}
