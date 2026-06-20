package com.farmbasket.backend.dto;

import com.farmbasket.backend.entity.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private Role role;
}