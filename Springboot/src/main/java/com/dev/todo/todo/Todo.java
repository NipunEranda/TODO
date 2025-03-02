package com.dev.todo.todo;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record Todo(
        Integer id,
        @NotEmpty
        String title,
        String body,
        LocalDateTime createdOn,
        Boolean deleted) {
}
