package com.example.express_dena.asyn;

import java.util.List;

/**
 * 事件处理类 的 接口 ，成为 事件处理类必须实现 ， 并注入到spring容器中
 * @author 王志坚
 * @createTime 2019.04.27.11:41
 */
public interface EventHandler {

    void doHandler(Event event);

    List<EventType> getSupportEventTypes();

}
