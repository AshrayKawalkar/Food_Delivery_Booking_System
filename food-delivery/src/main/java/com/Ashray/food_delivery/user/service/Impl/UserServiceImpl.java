package com.Ashray.food_delivery.user.service.Impl;

import com.Ashray.food_delivery.user.dto.RegisterUserRequest;
import com.Ashray.food_delivery.user.entity.User;
import com.Ashray.food_delivery.user.repository.UserRepository;
import com.Ashray.food_delivery.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public RegisterUserRequest userRegister(RegisterUserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        userRepository.save(user);

        return request;
    }
}
