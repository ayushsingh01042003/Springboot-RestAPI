package com.Ayush.Spring_REST.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Todo")
public class CRUD {

    private final List<Todo> todos = new ArrayList<>();

    @GetMapping("/")
    public String[] home() {
        return new String[]{"Str1", "Str2", "Str3"};
    }

    @GetMapping("/getAllTodos")
    public List<Todo> getAllTodos() {
        return todos;
    }

    @GetMapping("/getTodo/{ID}")
    public ResponseEntity<Object> getTodo(@PathVariable("ID") int todoID) {
        try {
            for (Todo todo : todos) {
                if(todo.getTodo_id() == todoID) {
                    return ResponseEntity
                            .status(HttpStatus.OK)
                            .body(todo);
                }
            }
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body("Todo ID does not exist");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Something went wrong: " + e.getMessage());
        }
    }

    @PostMapping("/createTodo")
    public ResponseEntity<String> createTodo(@RequestBody Todo todo) {
        todos.add(todo);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Created Successfully: " + todo);
    }

    @PutMapping("/updateTodo")
    public ResponseEntity<Object> updateTodo(@RequestParam int ID) {
        for (Todo todo : todos) {
            if(todo.getTodo_id() == ID) {
              todo.setCompleted(!todo.isCompleted());
              return ResponseEntity
                      .status(HttpStatus.OK)
                      .body(todo);
            }
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Todo ID does not exist");
    }

    @DeleteMapping("/deleteTodo")
    public ResponseEntity<String> deleteTodo(@RequestParam int ID) {
        for (Todo todo : todos) {
            if(todo.getTodo_id() == ID) {
                todos.remove(todo);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("Deleted Successfully");
            }
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Not found");
    }
}