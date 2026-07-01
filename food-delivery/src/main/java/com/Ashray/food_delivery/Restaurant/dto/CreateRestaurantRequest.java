package com.Ashray.food_delivery.Restaurant.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRestaurantRequest {

    @NotBlank(message = "Restaurant name is required")
    private String name;
    @NotBlank(message = "Restaurant description is required")
    private String description;
    @NotBlank(message = "Restaurant address is required")
    private String address;
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number should be valid")
    private String phoneNumber;
    @URL(message = "Image URL should be valid")
    private String imageUrl;


}
