package com.example.express_dena.services.impl;

import com.example.express_dena.asyn.Event;
import com.example.express_dena.asyn.EventProductor;
import com.example.express_dena.asyn.EventType;
import com.example.express_dena.mapper.AdminMapper;
import com.example.express_dena.mapper.HorsemanMapper;
import com.example.express_dena.mapper.UserMapper;
import com.example.express_dena.pojo.*;
import com.example.express_dena.services.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @auther: XIE XING YU
 * @data: 2019/12/11
 */
@Service
public class AdminServiceimpl implements AdminService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    HorsemanMapper horsemanMapper;
    @Autowired
    EventProductor eventProductor;
    @Autowired
    AdminMapper adminMapper;


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
            example.or().andUsernameLike(serchname+"%").andStatusEqualTo((byte) 1);
            example.or().andEmailLike(serchname+"%").andStatusEqualTo((byte) 1);
            example.or().andPhoneLike(serchname+"%").andStatusEqualTo((byte) 1);
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
            example.or().andUsernameLike(serchname+"%").andStatusEqualTo((byte) -1);
            example.or().andEmailLike(serchname+"%").andStatusEqualTo((byte) -1);
            example.or().andPhoneLike(serchname+"%").andStatusEqualTo((byte) -1);
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

    /**
     * 查询启用骑手
     * @param indexpage
     * @param serchname
     * @return
     */
    @Override
    public PageInfo selectHorseman(Integer indexpage, String serchname) {
        if (indexpage == null){
            indexpage = 0;
        }

        HorsemanExample example = new HorsemanExample();
        if (serchname != null&&!serchname.equals("")){
            example.or().andUsernameLike(serchname+"%").andStatusEqualTo((byte) 1);
            example.or().andEmailLike(serchname+"%").andStatusEqualTo((byte) 1);
            example.or().andPhoneLike(serchname+"%").andStatusEqualTo((byte) 1);
        }else {
            example.or().andStatusEqualTo((byte) 1);
        }

        PageHelper.startPage(indexpage,10);
        List<Horseman> horsemen = horsemanMapper.selectByExample(example);
        PageInfo info = new PageInfo(horsemen,5);
        return info;
    }

    /**
     * 查询停用骑手
     * @param indexpage
     * @param serchname
     * @return
     */
    @Override
    public PageInfo selectHorsemanStop(Integer indexpage, String serchname) {
        if (indexpage == null){
            indexpage = 0;
        }

        HorsemanExample example = new HorsemanExample();
        if (serchname != null&&!serchname.equals("")){
            example.or().andUsernameLike(serchname+"%").andStatusEqualTo((byte) -1);
            example.or().andEmailLike(serchname+"%").andStatusEqualTo((byte) -1);
            example.or().andPhoneLike(serchname+"%").andStatusEqualTo((byte) -1);
        }else {
            example.or().andStatusEqualTo((byte) -1);
        }

        PageHelper.startPage(indexpage,10);
        List<Horseman> horsemen = horsemanMapper.selectByExample(example);
        PageInfo info = new PageInfo(horsemen,5);
        return info;
    }

    /**
     * 停用骑手
     * @param horsemanid
     * @return
     */
    @Override
    public boolean forzenHorseman(Integer horsemanid) {
        Horseman horseman = horsemanMapper.selectByPrimaryKey(horsemanid);
        horseman.setStatus((byte) -1);
        return horsemanMapper.updateByPrimaryKey(horseman)>0;
    }

    /**
     * 启用骑手
     * @param horsemanid
     * @return
     */
    @Override
    public boolean startHorseman(Integer horsemanid) {
        Horseman horseman = horsemanMapper.selectByPrimaryKey(horsemanid);
        horseman.setStatus((byte) 1);
        return horsemanMapper.updateByPrimaryKey(horseman)>0;
    }

    /**
     * 根据邮箱，电话，或者用户名查询所有骑手（serchname为空则查全部）
     * @param indexpage
     * @param serchname
     * @return
     */
    @Override
    public PageInfo selectAllHorseman(Integer indexpage, String serchname) {
        if (indexpage == null){
            indexpage = 0;
        }

        HorsemanExample example = new HorsemanExample();
        if (serchname != null&&!serchname.equals("")){
            example.or().andUsernameLike(serchname+"%");
            example.or().andEmailLike(serchname+"%");
            example.or().andPhoneLike(serchname+"%");
        }

        PageHelper.startPage(indexpage,10);
        List<Horseman> horsemen = horsemanMapper.selectByExample(example);
        PageInfo info = new PageInfo(horsemen,5);
        return info;
    }

    @Override
    public boolean checked_apply(Integer horsemanid, Byte status) {
        HorsemanExample horsemanExample = new HorsemanExample();
        String account;
        String password;
        //按id找到申请的记录
        Horseman horseman = horsemanMapper.selectByPrimaryKey(horsemanid);
        if (status == -1){
            horseman.setStatus(status);
            Event e = new Event();
            e.setEventType(EventType.SEND_MAIL);
            e.mapSet("key","checkfail");
            e.mapSet("email",horseman.getEmail());
            eventProductor.pushEvent(e);
        }else if (status == 1){
            do {
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                //生成账号
                account =uuid.substring(0,10);
                //生成密码
                 password = uuid.substring(10,18);
                horsemanExample.createCriteria().andAccountEqualTo(account);
                //查询一次如果账号存在则重新生成
            }while (horsemanMapper.selectByExample(horsemanExample)!=null);
            //将账号密码设入
            horseman.setAccount(account);
            horseman.setPassword(password);
            horseman.setStatus(status);
            Event event = new Event();
            event.setEventType(EventType.SEND_MAIL);
            event.mapSet("key","sendaccount");
            event.mapSet("email",horseman.getEmail());
            event.mapSet("account",account);
            event.mapSet("password",password);
            eventProductor.pushEvent(event);
        }
        return horsemanMapper.updateByPrimaryKey(horseman)>0;

    }

    @Override
    public Admin loadByAccount(String account) {
        AdminExample example = new AdminExample();
        example.createCriteria().andAccountEqualTo(account);

        List<Admin> admins = adminMapper.selectByExample(example);
        if(admins == null)
            return null;
        else if(admins.isEmpty())
            return null;
        else
            return admins.get(0);
    }

}
