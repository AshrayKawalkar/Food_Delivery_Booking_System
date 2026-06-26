package com.Ashray.food_delivery.user.service;

import com.Ashray.food_delivery.user.dto.RegisterUserRequest;
import com.Ashray.food_delivery.user.dto.RegisterUserResponse;
import com.Ashray.food_delivery.user.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    RegisterUserResponse userRegister(RegisterUserRequest request);


}
