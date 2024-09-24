package com.Ayush.Spring_REST.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.Ayush.Spring_REST.entity.User;

public interface UserService extends UserDetailsService {
    String addUser(User user);
}
