package com.example.express_dena.services;

import com.example.express_dena.pojo.Advertising;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;

public interface IManagerAdvertsingService {
    /**
     * 查询广告
     * @param index
     * @param constituency
     * @param title
     * @param status
     * @return
     */
    PageInfo selectAdversing(Integer index, String constituency, String title, Byte status);

    /**
     * 删除广告
     * @param advertising
     * @return
     */
    boolean deleteAdversing(Advertising advertising);

    /**
     * 批量删除广告
     * @param ids
     * @return
     */
    boolean deleteADs(Integer[] ids);

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
