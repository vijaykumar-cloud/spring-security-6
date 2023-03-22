package com.example.springsecurity.controller;

import com.example.springsecurity.model.Role;
import com.example.springsecurity.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/superadmin")
public class SuperadminController {

    private IUserService userService;

    @PostMapping("addRole")
    public ResponseEntity<String> addRole(@RequestBody Role role) {
        return new ResponseEntity<>("hi", HttpStatus.OK);
    }
}
