package com.example.express_dena.asyn;

/**
 * 事件类型的 枚举类型
 *
 * @author 王志坚
 * @createTime 2019.04.27.11:13
 */
public enum EventType {
    SEND_MAIL(0);


    private int eventValue;

    EventType(int eventValue){
        this.eventValue=eventValue;
    }

    public int getEventValue() {
        return eventValue;
    }
}
