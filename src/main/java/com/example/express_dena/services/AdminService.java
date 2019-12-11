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

    /**
     * 启用用户
     * @param userid
     * @return
     */
    boolean startUser(Integer userid);


    /**
     * 根据邮箱，电话，或者用户名查询启用骑手（serchname为空则查全部）
     * @param indexpage
     * @param serchname
     * @return
     */
    PageInfo selectHorseman(Integer indexpage, String serchname);

    /**
     * 根据邮箱，电话，或者用户名查询停用骑手（serchname为空则查全部）
     * @param indexpage
     * @param serchname
     * @return
     */
    PageInfo selectHorsemanStop(Integer indexpage, String serchname);

    /**
     * 冻结骑手
     * @param horsemanid
     * @return
     */
    boolean forzenHorseman(Integer horsemanid);

    /**
     * 启用骑手
     * @param horsemanid
     * @return
     */
    boolean startHorseman(Integer horsemanid);

    /**
     * 根据邮箱，电话，或者用户名查询所有骑手（serchname为空则查全部）
     * @param indexpage
     * @param serchname
     * @return
     */
    PageInfo selectAllHorseman(Integer indexpage,String serchname);

    /**
     * 审核骑手申请
     * @param horsemanid
     * @param status
     * @return
     */
    boolean checked_apply(Integer horsemanid,Byte status);
}
