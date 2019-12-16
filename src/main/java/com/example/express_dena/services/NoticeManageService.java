package com.example.express_dena.services;

import com.example.express_dena.pojo.Notice;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface NoticeManageService {

    //查询公告
    public PageInfo queryNotice(Integer indexpage, String keyword);

    //添加公告
    public Map<String,Object> addNotice(Notice notice);

    //修改公告
    public Map<String,Object> updateNotice(Notice notice);

    //删除公告
    public Map<String, Object> deleteNotice(Notice notice);

    //批量删除
    public boolean deleteNotice(Integer[] ids);

}
