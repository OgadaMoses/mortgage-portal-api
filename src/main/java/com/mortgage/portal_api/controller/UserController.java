package com.mortgage.portal_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mortgage.portal_api.dto.AddUserRequest;
import com.mortgage.portal_api.entity.AddUser;
import com.mortgage.portal_api.service.AddUserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final AddUserService userService;

    public UserController(AddUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<AddUser> registerUser(@RequestBody AddUserRequest request) {
        AddUser savedUser = userService.registerUser(request);
        return ResponseEntity.ok(savedUser);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<AddUser>> getAllUsers() {
        List<AddUser> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
