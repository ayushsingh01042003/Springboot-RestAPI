package com.Ayush.Spring_REST.controller;

import com.Ayush.Spring_REST.entity.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Todo")
public class TodoController {

    @GetMapping("/")
    public String[] home() {
        return new String[]{"Str1", "Str2", "Str3"};
    }

    @GetMapping("/getAllTodos")
    public List<Todo> getAllTodos() {
        return null;
    }

    @GetMapping("/getTodo/{ID}")
    public ResponseEntity<Object> getTodo(@PathVariable("ID") int todoID) {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Todo ID does not exist");
    }

    @PostMapping("/createTodo")
    public ResponseEntity<String> createTodo(@RequestBody Todo todo) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Created Successfully: " + todo);
    }

    @PutMapping("/updateTodo")
    public ResponseEntity<Object> updateTodo(@RequestParam int ID) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Todo ID does not exist");
    }

    @DeleteMapping("/deleteTodo")
    public ResponseEntity<String> deleteTodo(@RequestParam int ID) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Not found");
    }
}