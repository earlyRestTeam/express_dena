package com.example.express_dena.services;

import com.example.express_dena.pojo.Advertising;
import com.github.pagehelper.Page;

import java.util.Date;
import java.util.List;

public interface IManagerAdversingService {
    /**
     * 查询广告
     * @param constituency
     * @param createTime
     * @param endTime
     * @param status
     * @return
     */
    Page selectAdversing(String constituency, Date createTime, Date endTime, Byte status);

    /**
     * 删除广告
     * @param advertisingList
     * @return
     */
    boolean deleteAdversing(List<Advertising> advertisingList);

    /**
     * 添加广告
     * @param advertising
     * @return
     */
    boolean addAdversing(Advertising advertising);

    /**
     * 修改广告
     * @param advertising
     * @return
     */
    boolean updateAdversing(Advertising advertising);
}
