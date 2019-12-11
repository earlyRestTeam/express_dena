package com.example.express_dena.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.express_dena.asyn.Event;
import com.example.express_dena.asyn.EventProductor;
import com.example.express_dena.asyn.EventType;
import com.example.express_dena.pojo.Horseman;
import com.example.express_dena.pojo.User;
import com.example.express_dena.services.CodeCenter;
import com.example.express_dena.services.UserService;
import com.example.express_dena.util.APIResult;
import com.example.express_dena.util.StaticPool;
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

    @Autowired
    UserService userService;
    @Autowired
    EventProductor eventProductor;
    @Autowired
    CodeCenter codeCenter;

    @PostMapping("/user/update")
    public APIResult updateUserInfo(@RequestBody  User u, HttpServletRequest request){

//        HttpSession session = request.getSession();
//        User user = (User)session.getAttribute("user");
//        u.setId(u.getId());
        u.setId(1);
        APIResult result = null;
        Map<String, String> res = userService.updateUserInfo(u);
        if( res.get(StaticPool.ERROR) != null ){
            result = APIResult.genFailApiResponse(res.get(StaticPool.ERROR));
        }else {
            result = APIResult.genSuccessApiResponse(res.get(StaticPool.SUCCESS));
        }
        return result;
    }

    @PostMapping("/user/changePassword")
    public APIResult changePassword(@RequestBody JSONObject jsonObject){
        //        HttpSession session = request.getSession();
//        User user = (User)session.getAttribute("user");
//        u.setId(u.getId());

        APIResult result = null;

        String oldPassword = (String) jsonObject.get("oldPassword");
        String newPassword = (String) jsonObject.get("newPassword");

        if(StringUtils.isEmpty(oldPassword) || StringUtils.isEmpty(newPassword)){
            result =  APIResult.genFailApiResponse("PARAMS ERROR!");
            return result;
        }

        Map<String, String> res = userService.changePassword(1, oldPassword, newPassword);

        if( res.get(StaticPool.ERROR) != null ){
            result = APIResult.genFailApiResponse(res.get(StaticPool.ERROR));
        }else {
            result = APIResult.genSuccessApiResponse(res.get(StaticPool.SUCCESS));
        }
        return result;
    }

    @PostMapping("/getCode")
    public APIResult getCode(@RequestBody JSONObject jsonObject){
        APIResult result = null;
        String email = (String) jsonObject.get("email");

        if(StringUtils.isEmpty(email)){
            result =  APIResult.genFailApiResponse("PARAMS ERROR!");
            return result;
        }
        Event e = new Event();
        e.setEventType(EventType.SEND_MAIL);
        e.mapSet("mail",email);
        Boolean success = eventProductor.pushEvent(e);
        if( !success ){
            result = APIResult.genFailApiResponse("发送失败");
        }else {
            result = APIResult.genSuccessApiResponse("发送成功");
        }
    return result;
    }
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
    @PostMapping("/user/tixian")
    public APIResult tixian(@RequestBody JSONObject jsonObject){

        APIResult result = null;

        String payNum = (String) jsonObject.get("payNum");
        String count = (String) jsonObject.get("count");

        if(StringUtils.isEmpty(payNum) || StringUtils.isEmpty(count)){
            result =  APIResult.genFailApiResponse("PARAMS ERROR!");
            return result;
        }
        Map<String, String> res = userService.tixian(1, payNum, count);

        if( res.get(StaticPool.ERROR) != null ){
            result = APIResult.genFailApiResponse(res.get(StaticPool.ERROR));
        }else {
            result = APIResult.genSuccessApiResponse(res.get(StaticPool.SUCCESS));
        }
        return result;
    }
}
