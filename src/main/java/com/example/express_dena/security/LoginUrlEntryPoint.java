package com.example.express_dena.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


public class LoginUrlEntryPoint extends LoginUrlAuthenticationEntryPoint {

    // 路径 对应 登陆 入口
    private final Map<String, String> urlMapping = new HashMap<>();

    private PathMatcher pathMatcher = new AntPathMatcher();

    private String lastPoint;


    public LoginUrlEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
        //初始化 urlMapping
        urlMapping.put("/admin/**","/admin/login");
        urlMapping.put("/user/**","/user/login");
        urlMapping.put("/staff/**","/staff/login");
    }

    /**
     * 根据请求 跳转到 指定的 页面 父类 默认 使用 loginFormUrl
     * @param request
     * @param response
     * @param exception
     * @return
     */
    @Override
    protected String determineUrlToUseForThisRequest(HttpServletRequest request
            , HttpServletResponse response, AuthenticationException exception) {
        //获取 之前 要去 的 路径
        //去掉 项目 的 路径
        String path = request.getRequestURI().replace(request.getContextPath(), "");
        for(String s : urlMapping.keySet()){
            if( pathMatcher.match(s,path) ){
                lastPoint = urlMapping.get(s);
                return lastPoint;
            }
        }
        return super.determineUrlToUseForThisRequest(request, response, exception);
    }

    public String getLastPoint() {
        return lastPoint;
    }

    public void setLastPoint(String lastPoint) {
        this.lastPoint = lastPoint;
    }


}
