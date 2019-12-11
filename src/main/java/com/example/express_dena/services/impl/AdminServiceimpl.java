package com.example.express_dena.services.impl;

import com.example.express_dena.mapper.UserMapper;
import com.example.express_dena.pojo.User;
import com.example.express_dena.pojo.UserExample;
import com.example.express_dena.services.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther: XIE XING YU
 * @data: 2019/12/11
 */
@Service
public class AdminServiceimpl implements AdminService {

    @Autowired
    UserMapper userMapper;


    /**
     * 查询启用用户
     * @param indexpage
     * @param serchname
     * @return
     */
    @Override
    public PageInfo selectUsers(Integer indexpage,String serchname) {

        if (indexpage == null){
            indexpage = 0;
        }

        UserExample example = new UserExample();
        if (serchname != null&&!serchname.equals("")){
            example.or().andUsernameLike(serchname).andStatusEqualTo((byte) 1);
            example.or().andEmailLike(serchname).andStatusEqualTo((byte) 1);
            example.or().andPhoneLike(serchname).andStatusEqualTo((byte) 1);
        }else {
            example.or().andStatusEqualTo((byte) 1);
        }

        PageHelper.startPage(indexpage,10);
        List<User> users = userMapper.selectByExample(example);
        PageInfo info = new PageInfo(users,5);
        return info;
    }

    /**
     * 查询冻结用户
     * @param indexpage
     * @param serchname
     * @return
     */
    @Override
    public PageInfo selectUsersStop(Integer indexpage, String serchname) {
        if (indexpage == null){
            indexpage = 0;
        }

        UserExample example = new UserExample();
        if (serchname != null&&!serchname.equals("")){
            example.or().andUsernameLike(serchname).andStatusEqualTo((byte) -1);
            example.or().andEmailLike(serchname).andStatusEqualTo((byte) -1);
            example.or().andPhoneLike(serchname).andStatusEqualTo((byte) -1);
        }else {
            example.or().andStatusEqualTo((byte) -1);
        }

        PageHelper.startPage(indexpage,10);
        List<User> users = userMapper.selectByExample(example);
        PageInfo info = new PageInfo(users,5);
        return info;
    }

    /**
     * 冻结用户
     * @param userid
     * @return
     */
    @Override
    public boolean forzenUser(Integer userid) {
        User user = userMapper.selectByPrimaryKey(userid);
        user.setStatus((byte) -1);
        return userMapper.updateByPrimaryKey(user)>0;
    }

    /**
     * 启用用户
     * @param userid
     * @return
     */
    @Override
    public boolean startUser(Integer userid) {
        User user = userMapper.selectByPrimaryKey(userid);
        user.setStatus((byte) 1);
        return userMapper.updateByPrimaryKey(user)>0;
    }
}
