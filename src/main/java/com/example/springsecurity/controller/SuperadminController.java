package com.example.springsecurity.controller;

import com.example.springsecurity.dto.RegisterDto;
import com.example.springsecurity.model.Role;
import com.example.springsecurity.model.RoleName;
import com.example.springsecurity.service.IUserService;
import com.example.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/superadmin")
public class SuperadminController {

    private final UserService userService;

    @PostMapping("/addAdmin")
    public ResponseEntity<?> addAdminUser(@RequestBody RegisterDto registerDto) {
        return userService.register(registerDto, RoleName.ADMIN);
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody RegisterDto registerDto) {
        return userService.register(registerDto, RoleName.USER);
    }

    @GetMapping("/getUser")
    public ResponseEntity<List<RegisterDto>> getUserList(Principal principal) {
        return new ResponseEntity<>(userService.getUserList(principal.getName()), HttpStatus.OK);
    }
}
