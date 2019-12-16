package com.example.express_dena.services;

import com.example.express_dena.pojo.Horseman;

import java.util.Map;

/**
 * @author 王志坚
 * @createTime 2019.12.12.10:31
 */
public interface IStaffService {
    Horseman loadStaffByAccount(String account);

    /**
     * 修改密码
     * @param hosermanid
     * @param oldPassword
     * @param newPassword
     * @return
     */
    Map<String,String> updateChangePassword(int hosermanid, String oldPassword, String newPassword);

    /**
     * 修改信息
     * @param horseman
     * @return
     */
    Map<String,String> updateUserInfo(Horseman horseman);

    /**
     * 查骑手
     * @param horsemanid
     * @return
     */
    Horseman selectHorseman(Integer horsemanid);
}
