package com.example.express_dena.asyn;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 王志坚
 * @createTime 2019.04.27.11:08
 */
public class Event implements Serializable {
    private Long sendUserId;
    private Long acceptUserId;
    private EventType eventType;
    private Long entityId;
    private Long entityType;

    private Map<String,String> map = new HashMap<>();



    public Event mapSet(String key,String value){
        map.put(key,value);
        return this;
    }

    public String mapGet(String key){
        return map.get(key);
    }

    public Long getSendUserId() {
        return sendUserId;
    }

    public Event setSendUserId(Long sendUserId) {
        this.sendUserId = sendUserId;
        return this;
    }

    public Long getAcceptUserId() {
        return acceptUserId;
    }

    public Event setAcceptUserId(Long acceptUserId) {
        this.acceptUserId = acceptUserId;
        return this;
    }

    public EventType getEventType() {
        return eventType;
    }

    public Event setEventType(EventType eventType) {
        this.eventType = eventType;
        return this;
    }

    public Long getEntityId() {
        return entityId;
    }

    public Event setEntityId(Long entityId) {
        this.entityId = entityId;
        return this;
    }

    public Long getEntityType() {
        return entityType;
    }

    public Event setEntityType(Long entityType) {
        this.entityType = entityType;
        return this;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public Event setMap(Map<String, String> map) {
        this.map = map;
        return this;
    }
}
