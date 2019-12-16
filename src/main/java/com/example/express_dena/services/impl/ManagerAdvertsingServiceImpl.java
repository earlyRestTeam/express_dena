package com.example.express_dena.services.impl;

import com.example.express_dena.mapper.AdvertisingMapper;
import com.example.express_dena.pojo.Advertising;
import com.example.express_dena.pojo.AdvertisingExample;
import com.example.express_dena.services.IManagerAdvertsingService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 谢晓峰
 * @Classname ManagerAdvertsingServiceImpl
 * @Description TODO
 * @Date 2019/12/13 14:47
 * @Version V1.0
 */
@Service
public class ManagerAdvertsingServiceImpl implements IManagerAdvertsingService {

    @Autowired
    AdvertisingMapper advertisingMapper;

    @Override
    public PageInfo selectAdversing(Integer indexpage, String constituency, String title, Byte status) {
        constituency = constituency == null ? "" : constituency;
        title = title == null ? "" : title;
        status = status == null ? 0 : status;
        indexpage = indexpage == null ? 1 : indexpage;

        AdvertisingExample example = new AdvertisingExample();
        example.or().andConstituencyLike(constituency+"%")
                .andTitleLike("%"+title+"%")
                .andStatusEqualTo(status);


        PageHelper.startPage(indexpage,10);
        List<Advertising> advertisings = advertisingMapper.selectByExample(example);
        PageInfo info = new PageInfo(advertisings,5);

        return info;
    }

    @Override
    public boolean deleteAdversing(Advertising advertising) {
        return advertisingMapper.deleteByPrimaryKey(advertising.getId())>0;
    }

    @Override
    public boolean deleteADs(Integer[] ids) {
        for (int i=0; i<ids.length; i++){
            Advertising advertising = new Advertising();
            advertising.setId(ids[i]);
            if (! deleteAdversing(advertising)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAdversing(Advertising advertising) {
        return advertisingMapper.insertSelective(advertising)>0;
    }

    @Override
    public boolean updateAdversing(Advertising advertising) {
        return advertisingMapper.updateByPrimaryKeySelective(advertising)>0;
    }
}
