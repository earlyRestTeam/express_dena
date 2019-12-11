package com.example.express_dena.services.impl;

import com.example.express_dena.mapper.MessageMapper;
import com.example.express_dena.pojo.Message;
import com.example.express_dena.pojo.MessageExample;
import com.example.express_dena.services.IMessageService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 王志坚
 * @createTime 2019.12.11.21:52
 */
@Service
public class MessageService implements IMessageService {

    @Autowired
    MessageMapper messageMapper;

    @Override
    public PageInfo<Message> queryMessage(int entityId, int entityType, int index, int size) {

        MessageExample example = new MessageExample();
        MessageExample.Criteria criteria = example.createCriteria();
        criteria.andReceiveridEqualTo(entityId);
        criteria.andReceiverTypeEqualTo(entityId);
        example.setOrderByClause("send_time desc");

        PageHelper.startPage(index, size);

        List<Message> messages = messageMapper.selectByExample(example);

        PageInfo<Message> pageInfo = new PageInfo<>(messages);

        return pageInfo;
    }

    @Override
    public Map<String, String> sendMessage(Message message) {
        return null;
    }
}
