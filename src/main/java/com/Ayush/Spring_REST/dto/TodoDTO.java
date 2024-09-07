package com.Ayush.Spring_REST.dto;

import lombok.Data;

@Data
public class TodoDTO {
    private Integer todoId;
    private String title;
    private String description;
    private boolean completed;
}