package com.Ashray.food_delivery.user.service;

import com.Ashray.food_delivery.user.dto.LoginRequest;
import com.Ashray.food_delivery.user.dto.LoginResponce;
import com.Ashray.food_delivery.user.dto.RegisterUserRequest;
import com.Ashray.food_delivery.user.dto.RegisterUserResponse;
import com.Ashray.food_delivery.user.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {

    RegisterUserResponse userRegister(RegisterUserRequest request);
    LoginResponce login(LoginRequest request);


}
