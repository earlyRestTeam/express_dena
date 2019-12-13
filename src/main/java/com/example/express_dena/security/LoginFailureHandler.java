package com.example.express_dena.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 王志坚
 * @createTime 2019.12.06.9:20
 */
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private final MyUsernamePasswordAuthenticationFilter myUsernamePasswordAuthenticationFilter;


    public LoginFailureHandler(MyUsernamePasswordAuthenticationFilter myUsernamePasswordAuthenticationFilter){
        this.myUsernamePasswordAuthenticationFilter = myUsernamePasswordAuthenticationFilter;
    }


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        String type = myUsernamePasswordAuthenticationFilter.getType();

        String url = "/"+type+"/login?error=true";
        super.setDefaultFailureUrl(url);
        super.onAuthenticationFailure(request,response,exception);

    }
}
