package com.example.express_dena.asyn;

import java.util.List;


public interface EventHandler {

    void doHandler(Event event);

    List<EventType> getSupportEventTypes();

}
