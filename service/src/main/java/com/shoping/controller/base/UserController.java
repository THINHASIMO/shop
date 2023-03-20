package com.shoping.controller.base;

import com.shoping.entity.base.User;
import com.shoping.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @PostMapping("/user")
    public List<User> createUsers(@RequestBody List<User> users) {
        return service.saveUsers(users);
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return service.getAllUser();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    @PutMapping("/user")
    public User updateUserByName(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }
}
