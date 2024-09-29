package com.Ayush.Spring_REST.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ayush.Spring_REST.dto.LoginRequest;
import com.Ayush.Spring_REST.entity.User;
import com.Ayush.Spring_REST.service.JwtService;
import com.Ayush.Spring_REST.service.UserService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    
    private UserService userService;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    public AuthenticationController(UserService userService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "This end point is not secure";
    }

    @PostMapping("/Signup") 
    public String Signup(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() {
        return "Only the user can access this";
    }
    
    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthroity('ROLE_ADMIN')")
    public String adminProfile() {
        return "Only the admin can access this";
    }

    @PostMapping("/Login")
    public String login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(loginRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("Invalid user Request");
        }
    }
    
}