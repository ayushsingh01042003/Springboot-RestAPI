package com.Ayush.Spring_REST.service;

import com.Ayush.Spring_REST.dto.TodoDTO;
import com.Ayush.Spring_REST.entity.Todo;
import com.Ayush.Spring_REST.exception.TodoNotFoundException;
import com.Ayush.Spring_REST.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Optional<Todo> getTodoById(Integer Id) {
        return todoRepository.findById(Id);
    }

    @Override
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Integer Id, Todo updatedTodo) {
        Optional<Todo> currTodoOptional = todoRepository.findById(Id);

        if(currTodoOptional.isPresent()) {
            Todo existingTodo = currTodoOptional.get();
            existingTodo.setTitle(updatedTodo.getTitle());
            existingTodo.setDescription(updatedTodo.getDescription());
            existingTodo.setCompleted(updatedTodo.isCompleted());
            return todoRepository.save(existingTodo);
        } else {
            throw new TodoNotFoundException("Todo not found with id: " + Id);
        }
    }

    @Override
    public void deleteTodoById(Integer Id) {
        todoRepository.deleteById(Id);
    }

    @Override
    public Todo convertToEntity(TodoDTO dto) {
        Todo todo = new Todo();
        todo.setTodoId(dto.getTodoId());
        todo.setCompleted(dto.isCompleted());
        todo.setDescription(dto.getDescription());
        todo.setTitle(dto.getTitle());
        return todo;
    }

    @Override
    public TodoDTO convertToDTO(Todo todo) {
        TodoDTO dto = new TodoDTO();
        dto.setTodoId(todo.getTodoId());
        dto.setTitle(todo.getTitle());
        dto.setDescription(todo.getDescription());
        dto.setCompleted(todo.isCompleted());
        return dto;
    }
}
