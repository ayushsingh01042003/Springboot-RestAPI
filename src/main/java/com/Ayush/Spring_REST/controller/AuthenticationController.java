package com.Ayush.Spring_REST.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ayush.Spring_REST.dto.LoginRequest;
import com.Ayush.Spring_REST.dto.LoginResponse;
import com.Ayush.Spring_REST.dto.SignupRequest;
import com.Ayush.Spring_REST.entity.User;
import com.Ayush.Spring_REST.service.AuthenticationService;
import com.Ayush.Spring_REST.service.JwtService;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }
}