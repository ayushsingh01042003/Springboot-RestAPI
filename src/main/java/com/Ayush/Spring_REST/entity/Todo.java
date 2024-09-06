package com.Ayush.Spring_REST.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    @Column(name = "todo_id")
    private Integer todoId;
    @Column(nullable = false, unique = true)
    private String title;
    @Column(nullable = false)
    private String description;
    private boolean completed;
}
