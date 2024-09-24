package com.Ayush.Spring_REST.service;

import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;

public interface JwtService {
    String extractUsername(String token);
    String generateToken(UserDetails userDetails);
    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);
    long getExpirationTime();
    boolean isTokenValid(String token, UserDetails userDetails);
}
