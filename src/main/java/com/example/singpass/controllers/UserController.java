package com.example.singpass.controllers;

import com.example.singpass.entities.User;
import com.example.singpass.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/create")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping(value = "/readAll")
    public List<User> readAll() {
        return userService.readAll();
    }

    @GetMapping(value = "/readUser/{userId}")
    public User read(@PathVariable Long userId) {
        Optional<User> user = userService.readUser(userId);
        return user.isPresent() ? user.get() : null;
    }

    @PutMapping(value = "/update/{userId}")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @GetMapping("/test")
    public String greeting() {
        return "Hello, World";
    }



}
