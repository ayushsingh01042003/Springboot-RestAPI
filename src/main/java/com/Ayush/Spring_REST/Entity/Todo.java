package com.Ayush.Spring_REST.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    @Column(name = "todo_id")
    private int todoId;
    @Column(nullable = false, unique = true)
    private String title;
    @Column(nullable = false)
    private String description;
    private boolean completed;
}
