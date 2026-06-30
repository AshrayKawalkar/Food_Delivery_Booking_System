package com.Ashray.food_delivery.user.service.Impl;

import com.Ashray.food_delivery.exception.EmailAlreadyExistsException;
import com.Ashray.food_delivery.exception.InvalidCredentialsException;
import com.Ashray.food_delivery.security.jwt.JwtService;
import com.Ashray.food_delivery.user.dto.LoginRequest;
import com.Ashray.food_delivery.user.dto.LoginResponce;
import com.Ashray.food_delivery.user.dto.RegisterUserRequest;
import com.Ashray.food_delivery.user.dto.RegisterUserResponse;
import com.Ashray.food_delivery.user.entity.User;
import com.Ashray.food_delivery.user.repository.UserRepository;
import com.Ashray.food_delivery.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    @Override
    public RegisterUserResponse userRegister(RegisterUserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists: " );
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setMessage("User registered successfully");
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());

        return response;
    }

    @Override
    public LoginResponce login(LoginRequest request) {

        User user=userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->  new InvalidCredentialsException("Invalid email or password"));

        if(!passwordEncoder.matches(request.getPassword(),user.getPassword())){
            throw new InvalidCredentialsException("Invalid email or password");
        }

        String token = jwtService.generateToken(user.getEmail());
        LoginResponce responce = new LoginResponce();
        responce.setToken(token);

        return responce;
    }
}
