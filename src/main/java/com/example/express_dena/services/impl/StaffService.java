package com.example.express_dena.services.impl;

import com.example.express_dena.mapper.HorsemanMapper;
import com.example.express_dena.pojo.Horseman;
import com.example.express_dena.pojo.HorsemanExample;
import com.example.express_dena.pojo.User;
import com.example.express_dena.pojo.UserExample;
import com.example.express_dena.services.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
