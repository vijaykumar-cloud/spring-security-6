package com.example.springsecurity.controller;

import com.example.springsecurity.dto.LoginDto;
import com.example.springsecurity.dto.RegisterDto;
import com.example.springsecurity.model.User;
import com.example.springsecurity.service.SecurityUserDetailsService;
import com.example.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register (@RequestBody RegisterDto registerDto) {
        return  userService.register(registerDto);
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody LoginDto loginDto) {
        return  userService.authenticate(loginDto);
    }

}
