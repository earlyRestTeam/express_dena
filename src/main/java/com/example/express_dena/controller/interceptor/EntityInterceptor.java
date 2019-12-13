package com.example.express_dena.controller.interceptor;

import com.example.express_dena.security.LoginEntityHelper;
import com.example.express_dena.security.LoginUrlEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 王志坚
 * @createTime 2019.12.13.19:00
 */
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
            if(modelAndView != null)
                modelAndView.addObject("entity",o);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
