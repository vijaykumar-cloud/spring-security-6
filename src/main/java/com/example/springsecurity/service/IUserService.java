package com.example.springsecurity.service;

import com.example.springsecurity.dto.LoginDto;
import com.example.springsecurity.dto.RegisterDto;
import com.example.springsecurity.model.Role;
import com.example.springsecurity.model.RoleName;
import com.example.springsecurity.model.User;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    String authenticate(LoginDto loginDto);
    ResponseEntity<?> register (RegisterDto registerDto, RoleName roleName);
    Role saveRole(Role role);
    User saverUser (User user) ;
}
