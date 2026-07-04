package com.Ashray.food_delivery.Menu.service;


import com.Ashray.food_delivery.Menu.dto.CreateMenuRequest;
import com.Ashray.food_delivery.Menu.dto.MenuResponse;
import com.Ashray.food_delivery.Menu.dto.UpdateMenuRequest;

import java.util.List;

public interface MenuService {

    MenuResponse createMenu(Long restaurantId , CreateMenuRequest request);
    MenuResponse updateMenu(Long id, UpdateMenuRequest request);
    void deleteMenu(Long id);

    MenuResponse getMenuById(Long id);

    List<MenuResponse> getAllMenus();

     List<MenuResponse>  getMenusByRestaurantId(Long restaurantId);


}
