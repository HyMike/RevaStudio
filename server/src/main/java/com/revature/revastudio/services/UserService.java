package com.revature.revastudio.services;

import com.revature.revastudio.entity.User;
import com.revature.revastudio.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User authenticate(String username, String password){
        User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new IllegalArgumentException("Invalid Username & Password"));

        if (!user.getPassword().equals(password)){
            throw new IllegalArgumentException("Incorrect Password");
        }

        return user;
    }





}

