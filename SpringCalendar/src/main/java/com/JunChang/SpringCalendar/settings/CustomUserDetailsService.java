package com.JunChang.SpringCalendar.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

import com.JunChang.SpringCalendar.bean.UserBean;
 
 
@Component
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    PasswordEncoder encoder;
 
    @Override
    public UserBean loadUserByUsername(String username) throws UsernameNotFoundException {
        UserBean user = new UserBean();
        
        final String examUsername = "exam@exam.com";
        final String examPassword = "1234";
        
        user.setUsername(username);
        if(user.getUsername().equals(examUsername)){
            user.setUsername(examUsername);
            user.setPassword(encoder.encode(examPassword));
            user.setNickname("Spring Security Project Example");
            user.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_USER"));
        }
        else{
            throw new UsernameNotFoundException(username);
        }
        return user;
    }
    
}