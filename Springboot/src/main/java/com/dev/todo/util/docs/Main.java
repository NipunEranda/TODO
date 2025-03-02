package com.dev.todo.util.docs;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {
    @GetMapping("/home")
    public String home(HttpServletRequest request) {
        return "Welcome User.";
    }
}
