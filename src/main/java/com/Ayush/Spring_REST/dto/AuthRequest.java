package com.Ayush.Spring_REST.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
