package com.daria.realestatenews.controller;

import com.daria.realestatenews.dto.UserCreationDTO;
import com.daria.realestatenews.model.User;
import com.daria.realestatenews.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/news/user")
@CrossOrigin
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody UserCreationDTO user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }
}
