package com.example.express_dena.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;


public class LoginSuccessHandler implements
        AuthenticationSuccessHandler {

    private final  LoginUrlEntryPoint loginUrlEntryPoint;

    public LoginSuccessHandler(LoginUrlEntryPoint loginUrlEntryPoint){
        this.loginUrlEntryPoint = loginUrlEntryPoint;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String url = null;

        for (GrantedAuthority g : authorities){
            if( g.getAuthority().equals("ROLE_admin") ){
                url = "/admin/index";
                break;
            }else if(g.getAuthority().equals("ROLE_staff")){
                url = "/staff/staffmain";
            }
        }
        if(url == null)
            url = "/user/main";
        response.sendRedirect(url);
    }


}
