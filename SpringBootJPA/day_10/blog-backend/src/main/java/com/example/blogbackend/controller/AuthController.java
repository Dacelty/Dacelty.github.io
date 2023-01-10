package com.example.blogbackend.controller;

import com.example.blogbackend.request.LoginRequest;
import com.example.blogbackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("handle-login")
    public String login(@RequestBody LoginRequest request, HttpSession session) {
        return authService.login(request, session);
    }

    @GetMapping("handle-logout")
    public String logout(HttpSession session) {
        return authService.logout(session);
    }
}
