package com.example.Spring.MVC.service;

import com.example.Spring.MVC.mappers.UserMapper;
import com.example.Spring.MVC.model.User;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {

    private final HashService hashService;
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper, HashService hashService) {
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    public int createUser(User user){
        SecureRandom secureRandom = new SecureRandom();
        byte [] salt = new byte[16];
        secureRandom.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.HashService(user.getPassword(), encodedSalt);
        return userMapper.createUser(new User(null, user.getUsername(),user.getLastname(), user.getFirstname(), hashedPassword ,encodedSalt ));

    }
    public boolean isUserAvaliable(String username){
        return userMapper.getUser(username) == null;
    }

}
