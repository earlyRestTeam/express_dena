package com.example.express_dena.security;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

/**
 * @author 王志坚
 * @createTime 2019.12.05.21:52
 */
@Service
public class AuthProvider implements AuthenticationProvider {



    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = (String) authentication.getCredentials();

//        Users u = usersService.findUsersByUserName(name);
//
//        if(u == null)
//            throw new BadCredentialsException("error");
//        if(password.equals(u.getUserpwd())){
//            return new UsernamePasswordAuthenticationToken(u.getUsername(),u.getUserpwd(),u.getAuthorities());
//        }else
//            throw new BadCredentialsException("error");
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
