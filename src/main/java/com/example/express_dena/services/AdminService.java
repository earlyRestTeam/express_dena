package com.example.express_dena.services;

import com.example.express_dena.pojo.User;
import com.github.pagehelper.PageInfo;

public interface AdminService {


    /**
     * 根据邮箱，电话，或者用户名查询启用用户（serchname为空则查全部）
     * @param indexpage
     * @param serchname
     * @return
     */
    PageInfo selectUsers(Integer indexpage, String serchname);

    /**
     * 根据邮箱，电话，或者用户名查询停用用户（serchname为空则查全部）
     * @param indexpage
     * @param serchname
     * @return
     */
    PageInfo selectUsersStop(Integer indexpage, String serchname);

    /**
     * 冻结用户
     * @param userid
     * @return
     */
    boolean forzenUser(Integer userid);

    boolean startUser(Integer userid);

}
