package com.revature.revastudio.controllers;

import com.revature.revastudio.dto.LoginDTO;
import com.revature.revastudio.dto.TokenTransport;
import com.revature.revastudio.entity.User;
import com.revature.revastudio.services.UserService;
import com.revature.revastudio.util.JwtUtil;
import io.jsonwebtoken.Jwt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public UserController(UserService userService, JwtUtil jwtUtil){
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenTransport> login(@RequestBody LoginDTO loginDTO){

        User user = this.userService.authenticate(loginDTO.getUsername(), loginDTO.getPassword());

        String token = jwtUtil.generateAccessToken(
                user.getId(),
                user.getUsername(),
                user.getRole()
        );

        TokenTransport tokenTransport = new TokenTransport();
        tokenTransport.setToken(token);

        return ResponseEntity.status(200).body(tokenTransport);

    }



}
