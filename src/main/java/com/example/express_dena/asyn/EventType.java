package com.example.express_dena.asyn;


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
