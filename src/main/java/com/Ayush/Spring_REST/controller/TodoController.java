package com.Ayush.Spring_REST.controller;

import com.Ayush.Spring_REST.dto.TodoDTO;
import com.Ayush.Spring_REST.entity.Todo;
import com.Ayush.Spring_REST.service.TodoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/Todo")
public class TodoController {

    TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public String[] home() {
        return new String[]{"Str1", "Str2", "Str3"};
    }

    @GetMapping("/getAllTodos")
    public ResponseEntity<List<TodoDTO>> getAllTodos() {
        List<Todo> todoList = todoService.getAllTodos();
        List<TodoDTO> todoDTOs = new ArrayList<>();

        for(Todo todo : todoList) {
            todoDTOs.add(todoService.convertToDTO(todo));
        }

        return new ResponseEntity<>(todoDTOs, HttpStatus.OK);
    }

    @GetMapping("/getTodo/{todoId}")
    public ResponseEntity<TodoDTO> getTodo(@PathVariable Integer todoId) {
        Optional<Todo> todo = todoService.getTodoById(todoId);
        if(todo.isPresent()) {
            TodoDTO todoDTO = todoService.convertToDTO(todo.get());
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(todoDTO);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/createTodo")
    public ResponseEntity<TodoDTO> createTodo(@RequestBody Todo todo) {
        TodoDTO todoDTO = todoService.convertToDTO(todoService.createTodo(todo));
        return new ResponseEntity<>(todoDTO, HttpStatus.OK);
    }

    @PutMapping("/updateTodo/{todoId}")
    public ResponseEntity<TodoDTO> updateTodo(@PathVariable Integer todoId, @RequestBody TodoDTO todoDTO) {
        return new ResponseEntity<>(todoService.convertToDTO(
            todoService.updateTodo(
                todoId, todoService.convertToEntity(todoDTO))), 
                HttpStatus.OK
            );
    }

    @DeleteMapping("/deleteTodo/{todoId}")
    public ResponseEntity<String> deleteTodo(@PathVariable Integer todoId) {
        todoService.deleteTodoById(todoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}