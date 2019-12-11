package com.example.express_dena.asyn;

import java.util.List;

/**
 * @author 王志坚
 * @createTime 2019.04.27.11:41
 */
public interface EventHandler {

    void doHandler(Event event);

    List<EventType> getSupportEventTypes();

}
