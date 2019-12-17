package com.example.express_dena.asyn;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


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
