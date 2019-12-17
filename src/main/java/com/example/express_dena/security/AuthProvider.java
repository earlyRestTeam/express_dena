package com.example.express_dena.security;

import com.example.express_dena.pojo.Admin;
import com.example.express_dena.pojo.Horseman;
import com.example.express_dena.pojo.User;
import com.example.express_dena.services.AdminService;
import com.example.express_dena.services.IStaffOrderService;
import com.example.express_dena.services.IStaffService;
import com.example.express_dena.services.UserService;
import com.example.express_dena.util.MD5Utils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
public class AuthProvider implements AuthenticationProvider {


    @Autowired
    MyUsernamePasswordAuthenticationFilter myUsernamePasswordAuthenticationFilter;
    @Autowired
    AdminService adminService;
    @Autowired
    IStaffService staffService;
    @Autowired
    UserService userService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String type = myUsernamePasswordAuthenticationFilter.getType();


        String name = authentication.getName();
        String password = MD5Utils.StringInMd5( (String) authentication.getCredentials() );
        String truePassword;
        UserDetails obj;
        switch (type){
            case "admin":
                Admin admin = adminService.loadByAccount(name);
                truePassword = (admin == null ? null:admin.getPassword() );
                if(admin != null)
                    admin.setPassword(null);
                obj = admin;

                break;
            case "staff":
                Horseman h = staffService.loadStaffByAccount(name);
                truePassword = (h == null ? null:h.getPassword() );
                if(h != null)
                    h.setPassword(null);
                obj = h;

                break;
            case "user":
                User user = userService.selectByUserName(name);
                truePassword = (user == null ? null:user.getPassword() );
                if(user != null)
                    user.setPassword(null);
                obj = user;

                break;
            default:
                throw new BadCredentialsException("error");
        }
//        Users u = usersService.findUsersByUserName(name);
//
        if(obj == null)
            throw new BadCredentialsException("用户名 错误");
        if(password.equals(truePassword)){
            return new UsernamePasswordAuthenticationToken(obj,password,obj.getAuthorities());
        }else
            throw new BadCredentialsException("用户名 或 密码 错误");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
