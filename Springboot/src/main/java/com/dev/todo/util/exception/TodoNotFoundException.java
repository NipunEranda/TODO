package com.dev.todo.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException() {
        super("Todo Not Found");
    }
}
