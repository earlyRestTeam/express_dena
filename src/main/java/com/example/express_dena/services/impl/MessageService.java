package com.example.express_dena.services.impl;

import com.example.express_dena.mapper.MessageMapper;
import com.example.express_dena.pojo.Message;
import com.example.express_dena.pojo.MessageExample;
import com.example.express_dena.services.IMessageService;
import com.example.express_dena.util.StaticPool;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageService implements IMessageService {

    @Autowired
    MessageMapper messageMapper;

    @Override
    public PageInfo<Message> queryMessage(int entityId, int entityType, Integer index, int size) {
        index = index == null ? 1: index;
        MessageExample example = new MessageExample();
        MessageExample.Criteria criteria = example.createCriteria();
        criteria.andReceiveridEqualTo(entityId);
        criteria.andReceiverTypeEqualTo(entityType);
        example.setOrderByClause("send_time desc");

        PageHelper.startPage(index, size);

        List<Message> messages = messageMapper.selectByExample(example);

        PageInfo<Message> pageInfo = new PageInfo<>(messages);

        return pageInfo;
    }



    //插入发送信息到数据库
    @Override
    public Map<String, String> sendMessage(Message message) {
        int result = messageMapper.insert(message);
        Map<String, String> map = new HashMap<>();
        if(result > 0){
            map.put(StaticPool.SUCCESS,"发送成功");
        }else{
            map.put(StaticPool.SUCCESS,"发送失败");
        }
        return map;
    }

    @Override
    public boolean updateReadMessage(Integer id) {
        Message message = messageMapper.selectByPrimaryKey(id);

        if(message != null){

            message.setStatus(2);
            return messageMapper.updateByPrimaryKeySelective(message) > 0;
        }else {
            throw new RuntimeException("error");
        }

    }

    @Override
    public int queryEntityUnreadMessageCount(int entityId, int entityType) {
        MessageExample example = new MessageExample();
        MessageExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(1);
        criteria.andReceiveridEqualTo(entityId);
        criteria.andReceiverTypeEqualTo(entityType);
        List<Message> messages = messageMapper.selectByExample(example);
        return messages == null ? 0 : messages.size();
    }
}
