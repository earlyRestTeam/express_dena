package com.example.express_dena.controller.interceptor;

import com.example.express_dena.pojo.Admin;
import com.example.express_dena.pojo.User;
import com.example.express_dena.security.LoginEntityHelper;
import com.example.express_dena.security.LoginUrlEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@Component
public class EntityInterceptor implements HandlerInterceptor {

    @Autowired
    LoginEntityHelper loginEntityHelper;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Object o = loginEntityHelper.getEntity();
        if( !(o instanceof String) ) //        "anonymousUser"
            if(modelAndView != null){
                int type;
                if(o instanceof User)
                    type = 1;
                else if(o instanceof Admin)
                    type = 2;
                else
                    type = 3;
                modelAndView.addObject("type",type);
                modelAndView.addObject("entity",o);
            }

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
