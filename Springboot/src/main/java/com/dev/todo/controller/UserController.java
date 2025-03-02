package com.dev.todo.controller;

import com.dev.todo.service.UserService;
import com.dev.todo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        System.out.println(user.toString());
        return "Success";
    }
}
