package com.Ayush.Spring_REST.controller;

import org.springframework.web.bind.annotation.RestController;

import com.Ayush.Spring_REST.dto.LoginRequest;
import com.Ayush.Spring_REST.dto.LoginResponse;
import com.Ayush.Spring_REST.service.JwtService;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private JwtService jwtUtils;
    private AuthenticationManager authenticationManager;

    public AuthController(JwtService jwtUtils, AuthenticationManager authenticationManager) {
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/welcome")
    public String welcomeString() {
        return "This end point is not Secure";
    }
        
    @PostMapping("/signup")
    public ResponseEntity<?> signupUserEntity() {
        return null;
    }
    

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest request) {
        Authentication authentication;
        
        try {
            authentication = authenticationManager
                            .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        } catch (AuthenticationException e) {
            Map<String, Object> map = new HashMap<>();
            map.put("message", "Bad Credentials");
            map.put("status", false);
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String jwtToken = jwtUtils.generateTokenFromUsername(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                                .map(item -> item.getAuthority())
                                .collect(Collectors.toList());
        
        LoginResponse response = new LoginResponse(jwtToken, userDetails.getUsername(), roles);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}