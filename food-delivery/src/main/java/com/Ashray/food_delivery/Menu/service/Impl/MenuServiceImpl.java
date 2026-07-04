package com.Ashray.food_delivery.Menu.service.Impl;

import com.Ashray.food_delivery.Menu.dto.CreateMenuRequest;
import com.Ashray.food_delivery.Menu.dto.MenuResponse;
import com.Ashray.food_delivery.Menu.dto.UpdateMenuRequest;
import com.Ashray.food_delivery.Menu.entity.Menu;
import com.Ashray.food_delivery.Menu.exception.MenuNotFoundException;
import com.Ashray.food_delivery.Menu.repository.MenuRepository;
import com.Ashray.food_delivery.Menu.service.MenuService;
import com.Ashray.food_delivery.Restaurant.entity.Restaurant;
import com.Ashray.food_delivery.Restaurant.exception.RestaurantNotFoundException;
import com.Ashray.food_delivery.Restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;



    @Override
    public MenuResponse createMenu(Long restaurantId, CreateMenuRequest request) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found"));

        Menu menu = new Menu();
            menu.setName(request.getName());
            menu.setDescription(request.getDescription());
            menu.setPrice(request.getPrice());
            menu.setImageUrl(request.getImageUrl());
            menu.setAvailable(true);
            menu.setRestaurant(restaurant);

        Menu save = menuRepository.save(menu);

        return mapToMenuResponse(save);
    }

    @Override
    public MenuResponse updateMenu(Long id, UpdateMenuRequest request) {

        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new MenuNotFoundException("Menu not found with id: " + id));

        menu.setName(request.getName());
        menu.setDescription(request.getDescription());
        menu.setPrice(request.getPrice());
        menu.setImageUrl(request.getImageUrl());
        menu.setAvailable(request.isAvailable());

        Menu saveMenu = menuRepository.save(menu);

        return mapToMenuResponse(saveMenu);
    }

    @Override
    public void deleteMenu(Long id) {

        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new MenuNotFoundException("Menu not found with id " + id));

        menuRepository.delete(menu);

    }

    @Override
    public MenuResponse getMenuById(Long id) {

        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new MenuNotFoundException("Menu not found with id " + id));

        return mapToMenuResponse(menu);
    }

    @Override
    public List<MenuResponse> getAllMenus() {

        List<Menu> all = menuRepository.findAll();

        return all.stream()
                .map(this::mapToMenuResponse)
                .toList();
    }

    @Override
    public List<MenuResponse> getMenusByRestaurantId(Long restaurantId) {

        List<Menu>  menus = menuRepository.findByRestaurantId(restaurantId);

        return menus.stream()
                .map(this::mapToMenuResponse)
                .toList();
    }

    private MenuResponse mapToMenuResponse(Menu menu) {

        MenuResponse response= new MenuResponse();
        response.setId(menu.getId());
        response.setName(menu.getName());
        response.setDescription(menu.getDescription());
        response.setPrice(menu.getPrice());
        response.setImageUrl(menu.getImageUrl());
        response.setAvailable(menu.isAvailable());
        response.setRestaurantId(menu.getRestaurant().getId());
        response.setCreatedAt(menu.getCreatedAt());
        response.setUpdatedAt(menu.getUpdatedAt());

        return response;
    }

}
