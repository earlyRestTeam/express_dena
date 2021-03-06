package com.example.express_dena.services;

import com.example.express_dena.pojo.Admin;
import com.example.express_dena.pojo.Comment;
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
    boolean updateUserForzen(Integer userid);

    /**
     * 启用用户
     * @param userid
     * @return
     */
    boolean updateUserStart(Integer userid);


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
    boolean updateHorsemanForzen(Integer horsemanid);

    /**
     * 启用骑手(重新将审核状态变为待审核0)
     * @param horsemanid
     * @return
     */
    boolean updateHorsemanStart(Integer horsemanid);

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
    boolean updateChecked_apply(Integer horsemanid,Byte status);

    Admin loadByAccount(String account);

    /**
     * 根据订单id，骑手id，或者用户id查询有效评论（serchid为空则查全部）
     * @param indexpage
     * @param serchid
     * @return
     */
    PageInfo selectComment(Integer indexpage,Integer serchid);

    /**
     * 根据订单id，骑手id，或者用户id查询停用评论（serchid为空则查全部）
     * @param indexpage
     * @param serchid
     * @return
     */
    PageInfo selectCommentStop(Integer indexpage,Integer serchid);

    /**
     * 冻结评论
     * @param commentid
     * @return
     */
    boolean updateCommentForzen(Integer commentid);

    /**
     * 启用评论
     * @param commentid
     * @return
     */
    boolean updateCommentStart(Integer commentid);

    /**
     * 只通过id查询详细的评论内容
     * @param commentid
     * @return
     */
    Comment selectCommentbyid(Integer commentid);

    /**
     * 查询提现申请
     * @param indexpage
     * @param status
     * @param serchid
     * @return
     */
    PageInfo selectDrawmoney(Integer indexpage,Integer status,Integer serchid);

    /**
     * 处理提现申请并且发送消息提醒
     * @param id
     * @param withdrawalsBalance
     * @return
     */
    boolean updateDrawmoney(Integer id,Float withdrawalsBalance);

    /**
     * 根据用户类型和ID查找消息列表
     * @param indexpage
     * @param receiver_type
     * @param serchid
     * @return
     */
    PageInfo selectMessaage(Integer indexpage,Integer receiver_type,Integer serchid);
}
