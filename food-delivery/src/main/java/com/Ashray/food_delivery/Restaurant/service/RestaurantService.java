package com.Ashray.food_delivery.Restaurant.service;

import com.Ashray.food_delivery.Restaurant.dto.CreateRestaurantRequest;
import com.Ashray.food_delivery.Restaurant.dto.RestaurantResponse;
import com.Ashray.food_delivery.Restaurant.dto.UpdateRestaurantRequest;
import com.Ashray.food_delivery.Restaurant.entity.Restaurant;

import java.util.List;

public interface RestaurantService {

    RestaurantResponse createRestaurant(CreateRestaurantRequest request);
    RestaurantResponse updateRestaurant( Long id , UpdateRestaurantRequest request );

    void deleteRestaurant(Long id);

    List<RestaurantResponse> getAllRestaurants();


    RestaurantResponse getRestaurantById(Long id);
}
