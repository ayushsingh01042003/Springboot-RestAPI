package com.Ayush.Spring_REST.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Ayush.Spring_REST.entity.User;
import com.Ayush.Spring_REST.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public UserServiceImp(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Optional<User> userDetails = userRepository.findByUsername(username);
        // return userDetails.map()
        return null;    
    }

    @Override
    public String addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User Added Successfully";
    }
    
}
