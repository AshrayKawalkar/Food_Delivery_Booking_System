package com.Ashray.food_delivery.Menu.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMenuRequest {

    @NotBlank(message = "Menu name is required")
    private String name;
    @NotBlank(message = "Menu description is required")
    private String description;

   @NotNull(message = "Menu price is required")
   @Positive(message = "Menu price must be greater than zero")
    private BigDecimal price;

    @URL(message = "Image URL should be valid")
    private String imageUrl;
    private boolean available;
}
