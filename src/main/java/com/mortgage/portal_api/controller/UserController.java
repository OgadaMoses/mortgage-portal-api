package com.mortgage.portal_api.controller;

import com.mortgage.portal_api.dto.UserRequest;
import com.mortgage.portal_api.entity.User;
import com.mortgage.portal_api.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Management API")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequest request) {
        User newUser = userService.createUser(request);
        return ResponseEntity.ok(newUser);
    }
}
