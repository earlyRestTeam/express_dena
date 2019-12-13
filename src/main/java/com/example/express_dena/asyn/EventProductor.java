package com.example.express_dena.asyn;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 事件 生产者 ， 负责 将事件发送到 事件队列中
 *
 * @author 王志坚
 * @createTime 2019.04.27.11:07
 */
@Component
public class EventProductor{
    @Autowired
    MessageQueue messageQueue;

    public Boolean pushEvent(Event event){
        try{
            String json = JSONObject.toJSONString(event);
            messageQueue.offer(json);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
