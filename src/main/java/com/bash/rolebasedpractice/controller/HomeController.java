package com.bash.rolebasedpractice.controller;

import com.bash.rolebasedpractice.model.Users;
import com.bash.rolebasedpractice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class HomeController {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @GetMapping("/")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER', 'MANAGER')")
    public String getHome(){
        return "Welcome to my project home page!";
    }

    @GetMapping("/users")
    public List<Users> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public Optional<Users> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.registerUser(user);
    }


}
