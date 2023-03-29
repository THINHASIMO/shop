package com.shoping.controller;

import com.shoping.entity.UserEntity;
import com.shoping.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/user")
    public UserEntity createUser(@RequestBody UserEntity userEntity) {
        return service.saveUser(userEntity);
    }

    @PostMapping("/user")
    public List<UserEntity> createUsers(@RequestBody List<UserEntity> userEntities) {
        return service.saveUsers(userEntities);
    }

    @GetMapping("/user")
    public List<UserEntity> getAllUsers() {
        return service.getAllUser();
    }

    @GetMapping("/user/{id}")
    public UserEntity getUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    @PutMapping("/user")
    public UserEntity updateUserByName(@RequestBody UserEntity userEntity) {
        return service.updateUser(userEntity);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }
}
