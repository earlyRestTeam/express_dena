package com.example.express_dena.services.impl;

import com.example.express_dena.mapper.NoticeMapper;
import com.example.express_dena.pojo.Notice;
import com.example.express_dena.pojo.NoticeExample;
import com.example.express_dena.services.NoticeManageService;
import com.example.express_dena.util.StaticPool;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class NoticeManageServiceImpl implements NoticeManageService {

    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public PageInfo queryNotice(Integer indexpage,@RequestParam(required = false)String keyword) {
        if (indexpage == null){
            indexpage = 0;
        }
        if (keyword == null){
            keyword="";
        }
        NoticeExample example = new NoticeExample();
        NoticeExample.Criteria criteria = example.createCriteria();
        criteria.andTitleLike(keyword+"%");

        PageHelper.startPage(indexpage,10);
        List<Notice> notices = noticeMapper.selectByExample(example);
        PageInfo info = new PageInfo(notices,5);
        return info;
    }

    @Override
    public Map<String, Object> addNotice(Notice notice) {
        Map<String,Object> res = new HashMap<>();
        notice.setCreateTime(new Date());
        notice.setStatus(Byte.valueOf("1"));
        int insert = noticeMapper.insert(notice);

        if (insert > 0){
            res.put(StaticPool.SUCCESS,"添加成功");
        }else{
            res.put(StaticPool.ERROR,"添加失败");
        }

        return res;
    }

    @Override
    public Map<String, Object> updateNotice(Notice notice) {
        Map<String,Object> res = new HashMap<>();
        notice.setCreateTime(new Date());
        notice.setStatus(Byte.valueOf("1"));
        int i = noticeMapper.updateByPrimaryKey(notice);
        if (i > 0){
            res.put(StaticPool.SUCCESS,"修改成功");
        }else{
            res.put(StaticPool.ERROR,"修改失败");
        }
        return res;
    }


    @Override
    public Map<String, Object> deleteNotice(Notice notice) {
        Map<String,Object> res = new HashMap<>();
        notice.setStatus(Byte.valueOf("0"));
        int i = noticeMapper.updateByPrimaryKeySelective(notice);
        if (i > 0){
            res.put(StaticPool.SUCCESS,"删除成功");
        }else{
            res.put(StaticPool.ERROR,"删除失败");
        }
        return res;
    }

    @Override
    public boolean deleteNotice(Integer[] ids) {
        for (int i=0; i<ids.length; i++){
            Notice notice = new Notice();
            notice.setId(ids[i]);
            Map<String, Object> res = deleteNotice(notice);
        }
        return true;
    }
}
