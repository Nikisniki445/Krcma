package com.example.demo.controller;


import com.example.demo.model.dto.UserCreatePayload;
import com.example.demo.model.dto.UserDetail;
import com.example.demo.model.dto.UserRow;
import com.example.demo.model.dto.UserUpdatePayload;
import com.example.demo.service.User1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class User1Controller {


    private final User1Service userService;


    @GetMapping("/all")
    public List<UserRow> getAllUsers() {

        return userService.getAllUsers();
    }


    @GetMapping("/{userId}")
    public UserDetail getUserDetail(@PathVariable(value = "userId") Long user1Id) {
        return userService.getUser1Detail(user1Id);
    }


    @PostMapping
    private void createUser(@RequestBody UserCreatePayload payload) {
        userService.createUser1(payload);
    }


    @PutMapping("/{userId}")
    private void updateUser1(
            @PathVariable(value = "userId") Long user1Id,
            @RequestBody UserUpdatePayload payload) {

        userService.updateUser1(user1Id, payload);
    }


    @DeleteMapping("/{userId}")
    private void deleteUser1(
            @PathVariable(value = "userId") Long user1Id) {

        userService.deleteUser1(user1Id);
    }


}
