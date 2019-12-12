package com.example.express_dena.security;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


/**
 * @author 王志坚
 * @createTime 2019.12.12.8:48
 */
@Component
public class LoginEntityHelper {

    public Object getEntity(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public <T> T getEntityByClass(Class<T> clazz){
        Object entity = getEntity();
        if(entity.getClass() == clazz)
            return clazz.cast(entity);
        else
            return null;

    }
}
