package com.Ashray.food_delivery.user.dto;

import lombok.Data;

@Data
public class RegisterUserResponse {

    private String message;
    private int id;
    private String name;
    private String email;
}
