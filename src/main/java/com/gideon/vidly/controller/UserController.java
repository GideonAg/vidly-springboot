package com.gideon.vidly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gideon.vidly.model.UserModel;
import com.gideon.vidly.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel) {
        userService.registerUser(userModel);
        return "User registration successful";
    }
}
