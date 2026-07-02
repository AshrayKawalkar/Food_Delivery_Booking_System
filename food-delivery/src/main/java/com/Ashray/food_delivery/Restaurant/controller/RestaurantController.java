package com.Ashray.food_delivery.Restaurant.controller;

import com.Ashray.food_delivery.Restaurant.dto.CreateRestaurantRequest;
import com.Ashray.food_delivery.Restaurant.dto.RestaurantResponse;
import com.Ashray.food_delivery.Restaurant.dto.UpdateRestaurantRequest;
import com.Ashray.food_delivery.Restaurant.service.Impl.RestaurantServiceImpl;
import com.Ashray.food_delivery.Restaurant.service.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
public class RestaurantController {


    private final RestaurantService restaurantService;

@PostMapping("/create")
    public ResponseEntity<RestaurantResponse> createRestaurant(@Valid
                                                               @RequestBody CreateRestaurantRequest request ){


        RestaurantResponse createRestaurant = restaurantService.createRestaurant(request);


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createRestaurant);
    }


    @PutMapping("/{id}")
    public ResponseEntity<RestaurantResponse> updateRestaurant( @Valid  @PathVariable Long id , @RequestBody UpdateRestaurantRequest request) {

        RestaurantResponse  updateRestaurant = restaurantService.updateRestaurant(id, request);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updateRestaurant);
    }

    @GetMapping
    public ResponseEntity<List<RestaurantResponse>> getAllRestaurant() {

        List<RestaurantResponse> allRestaurants = restaurantService.getAllRestaurants();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(allRestaurants);
    }


   @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponse> getRestaurantById(@PathVariable Long id) {

        RestaurantResponse restaurantById = restaurantService.getRestaurantById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(restaurantById);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {

        restaurantService.deleteRestaurant(id);

        return ResponseEntity.noContent().build();

    }

}
