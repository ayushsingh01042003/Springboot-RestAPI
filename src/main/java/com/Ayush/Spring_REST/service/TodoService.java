package com.Ayush.Spring_REST.service;

import com.Ayush.Spring_REST.dto.TodoDTO;
import com.Ayush.Spring_REST.entity.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    List<Todo> getAllTodos();
    Optional<Todo> getTodoById(Integer Id);
    Todo createTodo(Todo todo);
    Todo updateTodo(Integer Id, Todo todo);
    void deleteTodoById(Integer Id);
    Todo convertToEntity(TodoDTO dto);
    TodoDTO convertToDTO(Todo todo);
}
