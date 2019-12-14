package com.example.express_dena.services;

import com.example.express_dena.pojo.Message;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * @author 王志坚
 * @createTime 2019.12.11.21:52
 */
public interface IMessageService {

     PageInfo<Message> queryMessage(int entityId,int entityType,Integer index,int size);

     Map<String,String> sendMessage(Message message);

     /**
      * 改变未读为已读
      * @param id
      * @return
      */
     boolean updateReadMessage(Integer id);

     int queryEntityUnreadMessageCount(int entityId,int entityType);
}
