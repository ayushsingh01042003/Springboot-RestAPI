package com.Ayush.Spring_REST.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Ayush.Spring_REST.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
