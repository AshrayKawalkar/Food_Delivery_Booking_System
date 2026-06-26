package com.Ashray.food_delivery.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterUserRequest {
    @NotBlank(message = "Name is required")
    private String name;
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
}
