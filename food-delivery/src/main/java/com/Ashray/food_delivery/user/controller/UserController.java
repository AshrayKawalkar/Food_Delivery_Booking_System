package com.Ashray.food_delivery.user.controller;

import com.Ashray.food_delivery.user.dto.RegisterUserRequest;
import com.Ashray.food_delivery.user.entity.User;
import com.Ashray.food_delivery.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

@ResponseStatus(HttpStatus.OK)
@PostMapping("/register")
    public ResponseEntity<String> userRegister( @Valid @RequestBody RegisterUserRequest request) {

        userService.userRegister(request);

        return ResponseEntity.ok("User registered successfully");
    }



}
