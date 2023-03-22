package com.example.springsecurity.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterDto {
    String firstName ;
    String lastName ;
    String email;
    String password ;
}
