package com.Ayush.Spring_REST.repository;

import com.Ayush.Spring_REST.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findByCompleted(boolean completed);
    Optional<Todo> findByTitle(String title);
}
