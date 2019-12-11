package com.example.express_dena.services;

import com.example.express_dena.pojo.Horseman;
import com.example.express_dena.pojo.User;

import java.util.Map;

public interface UserService {
    int insert();

    /**
     * 注册 user
     * @param user
     * @return
     */
    Map<String,String> register(User user);

    /**
     * 修改 用户信息
     * @param user
     * @return
     */
    Map<String,String> updateUserInfo(User user);

    /**
     * 修改 用户密码
     * @param userid
     * @param oldPassword
     * @param newPassword
     * @return
     */
    Map<String,String> changePassword(int userid,String oldPassword,String newPassword);

    /**
     * 找回密码
     * @param emailCode
     * @param newPassword
     * @param account
     * @param code
     * @return
     */
    Map<String,String> forgetPassword(String emailCode,String newPassword
            ,String account,String code);

    /**
     * 认证 成为骑手
     * @param horseman
     * @return
     */
    Map<String,String> applicationStaff(Horseman horseman);

    /**
     * 充值
     * @param num
     * @return
     */
    Map<String,String> recharge(float num);

    Map<String,String> tixian(int horsemanId,String payNum,String count);

    Map<String,String> feedBack(String content,int orderid);

    Map<String,String> selectByIdAndName(String passwordd,String name);

    User selectByUserId(int id);
}
