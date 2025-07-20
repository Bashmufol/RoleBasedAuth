package com.bash.rolebasedpractice.controller;

import com.bash.rolebasedpractice.model.Users;
import com.bash.rolebasedpractice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @GetMapping("/")
    public String getHome(){
        return "Welcome to my project home page!";
    }

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.registerUser(user);
    }
}
