package com.example.express_dena.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CodeCenter {

    private ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();

    public String genCode(String mail){
        String code = UUID.randomUUID().toString().substring(0,6);
        map.put(mail,code);
        return code;
    }

    public String getCode(String mail){
        return map.get(mail);
    }

    public String removeCode(String mail){
        return map.remove(mail);
    }
}
