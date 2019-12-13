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
 * 事件消费者 -- 实现 ApplicationContextAware 获取 spring上下文
 * -- 实现 InitializingBean 在创建对象之后 进行初始化操作
 * @author 王志坚
 * @createTime 2019.04.27.12:04
 */
@Component
public class EventConsumer implements InitializingBean, ApplicationContextAware {
    private Map<EventType, List<EventHandler>> map;
    private ApplicationContext applicationContext;
    @Autowired
    MessageQueue messageQueue;

    /**
     * 初始化操作
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        map = new HashMap<EventType, List<EventHandler>>();
        //从spring上下文获取所有的EventHandler的实现类
        Map<String,EventHandler> eventHandlerBeans = applicationContext.getBeansOfType(EventHandler.class);

        if(eventHandlerBeans!=null){
            //遍历 map
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
        //开启 事件处理线程 暂时只开启 一条
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
