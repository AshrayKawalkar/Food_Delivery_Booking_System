package com.Ashray.food_delivery.user.controller;

import com.Ashray.food_delivery.user.dto.LoginRequest;
import com.Ashray.food_delivery.user.dto.LoginResponce;
import com.Ashray.food_delivery.user.dto.RegisterUserRequest;
import com.Ashray.food_delivery.user.dto.RegisterUserResponse;
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

@ResponseStatus(HttpStatus.CREATED)
@PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> userRegister(@Valid @RequestBody RegisterUserRequest request) {


    RegisterUserResponse response = userService.userRegister(request);

    return ResponseEntity.ok(response);
}


@PostMapping("/login")
public ResponseEntity<LoginResponce> login (@Valid  @RequestBody LoginRequest request) {

    LoginResponce responce = userService.login(request);

    return ResponseEntity.ok(responce);


}



}
