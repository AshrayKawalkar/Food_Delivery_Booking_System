package com.Ashray.food_delivery.Menu.service.Impl;

import com.Ashray.food_delivery.Menu.dto.CreateMenuRequest;
import com.Ashray.food_delivery.Menu.dto.MenuResponse;
import com.Ashray.food_delivery.Menu.dto.UpdateMenuRequest;
import com.Ashray.food_delivery.Menu.service.MenuService;

import java.util.List;

public class MenuServiceImpl implements MenuService {
    @Override
    public MenuResponse createMenu(Long id, CreateMenuRequest request) {
        return null;
    }

    @Override
    public MenuResponse updateMenu(Long id, UpdateMenuRequest request) {
        return null;
    }

    @Override
    public void deleteMenu(Long id) {

    }

    @Override
    public MenuResponse getMenuById(Long id) {
        return null;
    }

    @Override
    public List<MenuResponse> getAllMenus() {
        return List.of();
    }

    @Override
    public List<MenuResponse> getMenusByRestaurantId(Long restaurantId) {
        return List.of();
    }
}
