package com.dev.todo.docs;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {
    @GetMapping("")
    public String home(HttpServletRequest request) {
        return "Welcome.";
    }
}
