package com.example.express_dena.services.impl;

import com.example.express_dena.mapper.HorsemanMapper;
import com.example.express_dena.pojo.Horseman;
import com.example.express_dena.pojo.HorsemanExample;
import com.example.express_dena.pojo.User;
import com.example.express_dena.pojo.UserExample;
import com.example.express_dena.services.IStaffService;
import com.example.express_dena.util.MD5Utils;
import com.example.express_dena.util.StaticPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王志坚
 * @createTime 2019.12.12.10:32
 */
@Service
public class StaffService implements IStaffService {

    @Autowired
    HorsemanMapper horsemanMapper;

    @Override
    public Horseman loadStaffByAccount(String account) {
        HorsemanExample example = new HorsemanExample();
        HorsemanExample.Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(account);

        List<Horseman> horsemens = horsemanMapper.selectByExample(example);
        if(horsemens == null)
            return null;
        else if(horsemens.isEmpty())
            return null;
        else
            return horsemens.get(0);
    }

    @Override
    public Map<String, String> changePassword(int hosermanid, String oldPassword, String newPassword) {
        Map<String,String> res = new HashMap<>();

        Horseman horseman = horsemanMapper.selectByPrimaryKey(hosermanid);
        if(horseman == null)
            res.put(StaticPool.ERROR,"修改失败！此用户不存在！");
        else {
            if( horseman.getPassword().equals(MD5Utils.StringInMd5(oldPassword)) ){
                String password = MD5Utils.StringInMd5(newPassword);
                horseman.setPassword(password);
                if(horsemanMapper.updateByPrimaryKey(horseman) > 0){
                    res.put(StaticPool.SUCCESS,"修改成功！");
                }else {
                    res.put(StaticPool.ERROR,"修改失败！请稍后再试！");
                }

            }else {
                res.put(StaticPool.ERROR,"修改失败！旧密码错误！");
            }
        }
        return res;
    }

    @Override
    public Map<String, String> updateUserInfo(Horseman horseman) {
        Map<String,String> res = new HashMap<>();

        int id = horseman.getId();
        Horseman horseman1 = horsemanMapper.selectByPrimaryKey(id);

        horseman1.setUsername(horseman.getUsername());
        horseman1.setPhone(horseman.getPhone());
        horseman1.setAvatar(horseman.getAvatar());


        int ans = horsemanMapper.updateByPrimaryKey(horseman1);
        if(ans > 0 )
            res.put(StaticPool.SUCCESS,"修改成功！");
        else
            res.put(StaticPool.ERROR,"修改失败！");
        return res;
    }

    @Override
    public Horseman selectHorseman(Integer horsemanid) {
        return horsemanMapper.selectByPrimaryKey(horsemanid);
    }

}
