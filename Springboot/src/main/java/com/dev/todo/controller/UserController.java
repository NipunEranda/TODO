package com.dev.todo.controller;

import com.dev.todo.service.UserService;
import com.dev.todo.model.Users;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    HttpHeaders responseHeaders = new HttpHeaders();

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users user, HttpServletResponse response) {
        String token = userService.verify(user);

        Cookie cookie = new Cookie("client.token", token);
        cookie.setMaxAge(60 * 60 * 24); // 1 day
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setDomain("localhost");
        response.addCookie(cookie);

        return ResponseEntity.ok("success!");
    }

    @PostMapping("/login/google")
    public String googleLogin(HttpServletRequest request, HttpServletResponse response,
                              @RequestParam(required = false) String code) {
        return null;
    }
}
