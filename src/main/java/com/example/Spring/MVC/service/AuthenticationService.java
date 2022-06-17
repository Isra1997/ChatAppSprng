package com.example.Spring.MVC.service;

import com.example.Spring.MVC.mappers.UserMapper;
import com.example.Spring.MVC.model.User;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthenticationService implements AuthenticationProvider {
    HashService hashService;
    UserMapper userMappers;

    public AuthenticationService(HashService hashService,UserMapper userMapper) {
        this.hashService = hashService;
        this.userMappers = userMapper;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userMappers.getUser(username);
        if(user !=null){
            if(user.getPassword().equals(hashService.HashService(password,user.getSalt()))){
                return new UsernamePasswordAuthenticationToken(username,password,new ArrayList<>());
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
