package com.Ashray.food_delivery.Restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantResponse {
    private Long id;
    private String name;
    private String description;
    private String address;
    private String phoneNumber;
    private String imageUrl;
    private boolean isOpen;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
