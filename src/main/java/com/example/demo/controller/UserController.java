package com.example.demo.controller;

import com.example.demo.application.AppendService;
import com.example.demo.application.UserService;
import com.example.demo.domain.dto.UserDto;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/list")
    public List<UserDto> getUserList() {
        return userService.getAllUsers();
    }

    @PostMapping()
    public void saveUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);

    }


    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable(name = "id") Long id) {
        try {
            return userService.getUserById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
