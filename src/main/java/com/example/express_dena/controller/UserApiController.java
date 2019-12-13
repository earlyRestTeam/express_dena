package com.example.express_dena.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.express_dena.asyn.Event;
import com.example.express_dena.asyn.EventProductor;
import com.example.express_dena.asyn.EventType;
import com.example.express_dena.pojo.Horseman;
import com.example.express_dena.pojo.User;
import com.example.express_dena.security.LoginEntityHelper;
import com.example.express_dena.services.CodeCenter;
import com.example.express_dena.services.UserService;
import com.example.express_dena.util.APIResult;
import com.example.express_dena.util.StaticPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 王志坚
 * @createTime 2019.12.11.10:27
 */
@RestController
public class UserApiController {

    Logger logger = LoggerFactory.getLogger(UserApiController.class);

    @Autowired
    UserService userService;
    @Autowired
    EventProductor eventProductor;
    @Autowired
    CodeCenter codeCenter;
    @Autowired
    LoginEntityHelper loginEntityHelper;

    /**
     * 修改个人信息
     * @param u
     * @param request
     * @return
     */
    @PostMapping("/user/update")
    public APIResult updateUserInfo(@RequestBody  User u, HttpServletRequest request){

//        HttpSession session = request.getSession();
//        User user = (User)session.getAttribute("user");
//        u.setId(u.getId());
        User u2 = loginEntityHelper.getEntityByClass(User.class);
        if ( u2 == null )
            throw new RuntimeException("error");

        u.setId(u2.getId());

        APIResult result = null;
        Map<String, String> res = userService.updateUserInfo(u);
        if( res.get(StaticPool.ERROR) != null ){
            result = APIResult.genFailApiResponse(res.get(StaticPool.ERROR));
        }else {
            result = APIResult.genSuccessApiResponse(res.get(StaticPool.SUCCESS));
        }
        return result;
    }

    /**
     * 修改密码
     * @param jsonObject
     * @return
     */
    @PostMapping("/user/changePassword")
    public APIResult changePassword(@RequestBody JSONObject jsonObject){
        //        HttpSession session = request.getSession();
//        User user = (User)session.getAttribute("user");
//        u.setId(u.getId());

        User u2 = loginEntityHelper.getEntityByClass(User.class);
        if ( u2 == null )
            throw new RuntimeException("error");

        APIResult result = null;

        String oldPassword = (String) jsonObject.get("oldPassword");
        String newPassword = (String) jsonObject.get("newPassword");

        if(StringUtils.isEmpty(oldPassword) || StringUtils.isEmpty(newPassword)){
            result =  APIResult.genFailApiResponse("PARAMS ERROR!");
            return result;
        }

        Map<String, String> res = userService.changePassword(u2.getId(), oldPassword, newPassword);

        if( res.get(StaticPool.ERROR) != null ){
            result = APIResult.genFailApiResponse(res.get(StaticPool.ERROR));
        }else {
            result = APIResult.genSuccessApiResponse(res.get(StaticPool.SUCCESS));
        }
        return result;
    }

    /**
     * 账号找回
     * @param jsonObject
     * @return
     */
    @PostMapping("/findBack")
    public APIResult findBack(@RequestBody JSONObject jsonObject){
        APIResult result = null;
        String email = (String) jsonObject.get("email");
        String password = (String) jsonObject.get("password");
        String code = (String) jsonObject.get("code");
        if(StringUtils.isEmpty(email) || StringUtils.isEmpty(password)
                || StringUtils.isEmpty(code)){
            result =  APIResult.genFailApiResponse("PARAMS ERROR!");
            return result;
        }
        Map<String, String> res = userService.forgetPassword(email, password, email, code);
        if( res.get(StaticPool.ERROR) != null ){
            result = APIResult.genFailApiResponse(res.get(StaticPool.ERROR));
        }else {
            result = APIResult.genSuccessApiResponse(res.get(StaticPool.SUCCESS));
        }
        return result;
    }

    /**
     * 获取 找回账号、注册 的验证码
     * @param jsonObject
     * @return
     */
    @PostMapping("/getCode")
    public APIResult getCode(@RequestBody JSONObject jsonObject){
        String email = (String) jsonObject.get("email");
        String key = (String) jsonObject.get("key");
        return getCode(email,key);
    }
    private APIResult getCode(String email,String key){
        APIResult result = null;


        if(StringUtils.isEmpty(email)){
            result =  APIResult.genFailApiResponse("PARAMS ERROR!");
            return result;
        }
        Event e = new Event();
        e.setEventType(EventType.SEND_MAIL);
        e.mapSet("mail",email);
        e.mapSet("key",key);
        Boolean success = eventProductor.pushEvent(e);
        if( !success ){
            result = APIResult.genFailApiResponse("发送失败");
        }else {
            result = APIResult.genSuccessApiResponse("发送成功");
        }
        return result;
    }

    /**
     * 注册
     * @param jsonObject
     * @return
     */
    @PostMapping("register")
    public APIResult register(@RequestBody JSONObject jsonObject){

        APIResult result = null;

        String code = (String) jsonObject.get("code");
        String username = (String) jsonObject.get("username");
        String password = (String) jsonObject.get("password");
        String email = (String) jsonObject.get("email");
        String phone = (String) jsonObject.get("phone");
        if(StringUtils.isEmpty(code) ||
                StringUtils.isEmpty(username) ||
                StringUtils.isEmpty(password) ||
                StringUtils.isEmpty(email) || StringUtils.isEmpty(phone)){
            result =  APIResult.genFailApiResponse("PARAMS ERROR!");
            return result;
        }
        User user = new User();
        user.setPhone(phone);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        String mail = user.getEmail();
        String code2 = codeCenter.getCode(mail);

        if(code.equals(code)){
            codeCenter.removeCode(mail);

            Map<String, String> res = userService.register(user);
            if( res.get(StaticPool.ERROR) != null ){
                result = APIResult.genFailApiResponse(res.get(StaticPool.ERROR));
            }else {
                result = APIResult.genSuccessApiResponse(res.get(StaticPool.SUCCESS));
            }
        }else {
            result = APIResult.genFailApiResponse("验证码错误！请重新填写！");
        }

        return result;
    }

    /**
     * 成为骑手
     * @param horseman
     * @return
     */
    @PostMapping("/becomeToHorseman")
    public APIResult becomeToHorseman(@RequestBody Horseman horseman){

        APIResult result = null;

        if(StringUtils.isEmpty(horseman.getUsername()) ||
                StringUtils.isEmpty(horseman.getIdCard()) ||
                StringUtils.isEmpty(horseman.getEmail()) ||
                StringUtils.isEmpty(horseman.getIdCardPicBack()) ||
                StringUtils.isEmpty(horseman.getIdCardPicPre()) ||
                StringUtils.isEmpty(horseman.getPhone())){

            result =  APIResult.genFailApiResponse("PARAMS ERROR!");
            return result;
        }
        Map<String, String> res = userService.applicationStaff(horseman);
        if( res.get(StaticPool.ERROR) != null ){
            result = APIResult.genFailApiResponse(res.get(StaticPool.ERROR));
        }else {
            result = APIResult.genSuccessApiResponse(res.get(StaticPool.SUCCESS));
        }
        return result;
    }

    /**
     * 骑手提现
     * @param jsonObject
     * @return
     */
    @PostMapping("/staff/tixian")
    public APIResult tixian(@RequestBody JSONObject jsonObject){

        Horseman u2 = loginEntityHelper.getEntityByClass(Horseman.class);
        if ( u2 == null )
            throw new RuntimeException("error");

        APIResult result = null;

        String payNum = (String) jsonObject.get("payNum");
        String count = (String) jsonObject.get("count");

        if(StringUtils.isEmpty(payNum) || StringUtils.isEmpty(count)){

            result =  APIResult.genFailApiResponse("PARAMS ERROR!");
            return result;
        }
        Map<String, String> res = userService.tixian(u2.getId(), payNum, count);

        if( res.get(StaticPool.ERROR) != null ){
            result = APIResult.genFailApiResponse(res.get(StaticPool.ERROR));
        }else {
            result = APIResult.genSuccessApiResponse(res.get(StaticPool.SUCCESS));
        }
        return result;
    }
}
