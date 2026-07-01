package com.Ashray.food_delivery.Restaurant.service.Impl;

import com.Ashray.food_delivery.Restaurant.dto.CreateRestaurantRequest;
import com.Ashray.food_delivery.Restaurant.dto.RestaurantResponse;
import com.Ashray.food_delivery.Restaurant.dto.UpdateRestaurantRequest;
import com.Ashray.food_delivery.Restaurant.entity.Restaurant;
import com.Ashray.food_delivery.Restaurant.exception.RestaurantNotFoundException;
import com.Ashray.food_delivery.Restaurant.repository.RestaurantRepository;
import com.Ashray.food_delivery.Restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public RestaurantResponse createRestaurant(CreateRestaurantRequest request) {

        Restaurant restaurant = new Restaurant();
        restaurant.setName(request.getName());
        restaurant.setDescription(request.getDescription());
        restaurant.setAddress(request.getAddress());
        restaurant.setPhoneNumber(request.getPhoneNumber());
        restaurant.setImageUrl(request.getImageUrl());
        restaurant.setOpen(true);

        Restaurant saveRestaurant = restaurantRepository.save(restaurant);

        return mapToResponse(saveRestaurant);
    }



    @Override
    public RestaurantResponse updateRestaurant(Long id, UpdateRestaurantRequest request) {

        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found with id: " + id));


        restaurant.setName(request.getName());
        restaurant.setDescription(request.getDescription());
        restaurant.setAddress(request.getAddress());
        restaurant.setPhoneNumber(request.getPhoneNumber());
        restaurant.setImageUrl(request.getImageUrl());
        restaurant.setOpen(request.isOpen());

        Restaurant save = restaurantRepository.save(restaurant);


        return mapToResponse(save);
    }



    @Override
    public void deleteRestaurant(Long id) {

        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found with id: " + id));


        restaurantRepository.delete(restaurant);
    }




    @Override
    public List<RestaurantResponse> getAllRestaurants() {

        List<Restaurant> all = restaurantRepository.findAll();


        return all.stream()
                .map(this::mapToResponse)
                .toList();
    }


    @Override
    public RestaurantResponse getRestaurantById(Long id) {

        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found with id: " + id));

        return mapToResponse(restaurant);
    }




    // Helper Method

    private RestaurantResponse mapToResponse(Restaurant restaurant) {
        RestaurantResponse response = new RestaurantResponse();
        response.setId(restaurant.getId());
        response.setName(restaurant.getName());
        response.setDescription(restaurant.getDescription());
        response.setAddress(restaurant.getAddress());
        response.setPhoneNumber(restaurant.getPhoneNumber());
        response.setImageUrl(restaurant.getImageUrl());
        response.setOpen(restaurant.isOpen());
        response.setCreatedAt(restaurant.getCreatedAt());
        response.setUpdatedAt(restaurant.getUpdatedAt());
        return response;
    }
}
