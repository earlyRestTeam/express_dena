package com.example.express_dena.asyn;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王志坚
 * @createTime 2019.04.27.12:04
 */
@Component
public class EventConsumer implements InitializingBean, ApplicationContextAware {
    private Map<EventType, List<EventHandler>> map;
    private ApplicationContext applicationContext;
    @Autowired
    MessageQueue messageQueue;

    @Override
    public void afterPropertiesSet() throws Exception {
        map = new HashMap<EventType, List<EventHandler>>();
        //充spring上下文获取所有的EventHandler的实现类
        Map<String,EventHandler> eventHandlerBeans = applicationContext.getBeansOfType(EventHandler.class);

        if(eventHandlerBeans!=null){
            for (Map.Entry<String,EventHandler> entry : eventHandlerBeans.entrySet()){

                List<EventType> eventTypes = entry.getValue().getSupportEventTypes();

                for (EventType eventType : eventTypes) {
                    if(!map.containsKey(eventType)){
                        map.put(eventType,new ArrayList<EventHandler>());
                    }
                    map.get(eventType).add(entry.getValue());
                }
            }
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){

                    String message = messageQueue.take();

                    if(message != null){
                        Event event = JSON.parseObject(message,Event.class);

                        if(!map.containsKey(event.getEventType())){
//                                logger.error("无法识别的事件");
                            System.out.println("error 无法识别的事件");
                        }

                        for(EventHandler eventHandler:map.get(event.getEventType())){
                            eventHandler.doHandler(event);
                        }
                    }

                }
            }
        });
        thread.start();
    }

    //获取spring上下文
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
