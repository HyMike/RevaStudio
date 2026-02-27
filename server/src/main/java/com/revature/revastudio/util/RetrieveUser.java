package com.revature.revastudio.util;

import com.revature.revastudio.entity.User;
import com.revature.revastudio.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RetrieveUser {

    private final UserRepository userRepository;

    public RetrieveUser(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    public UUID getUser() {
        UUID userId = (UUID) SecurityContextHolder.getContext().getAuthentication().getDetails();
//        User user = this.userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("No such User found with this ticket"));
        return userId;
    }


}
