package com.Ashray.food_delivery.Menu.controller;

import com.Ashray.food_delivery.Menu.dto.CreateMenuRequest;
import com.Ashray.food_delivery.Menu.dto.MenuResponse;
import com.Ashray.food_delivery.Menu.dto.UpdateMenuRequest;
import com.Ashray.food_delivery.Menu.service.MenuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurants")
public class MenuController {


    private final MenuService menuService;


    @PostMapping("/{restaurantId}/menus")
    public ResponseEntity<MenuResponse> createMenu( @PathVariable Long restaurantId ,
                                                    @Valid @RequestBody CreateMenuRequest request) {

        MenuResponse menuCreate = menuService.createMenu(restaurantId, request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(menuCreate);
    }


    @PutMapping("/menus/{id}")
    public ResponseEntity<MenuResponse> updateMenu(  @PathVariable Long id,
                                                     @Valid @RequestBody UpdateMenuRequest request) {

        MenuResponse response = menuService.updateMenu(id, request);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);

    }

    @DeleteMapping("/menus/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {

        menuService.deleteMenu(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/menus")
    public ResponseEntity<List<MenuResponse>> getAllMenu() {
        List<MenuResponse> allMenus = menuService.getAllMenus();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(allMenus);
    }

    @GetMapping("/menus/{id}")
    public ResponseEntity<MenuResponse> getMenuById(@PathVariable Long id) {

        MenuResponse menuById = menuService.getMenuById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(menuById);
    }

    @GetMapping("/{restaurantId}/menus")
    public ResponseEntity<List<MenuResponse>> getMenusByRestaurantId(
            @PathVariable Long restaurantId)
    {
        List<MenuResponse> menus= menuService.getMenusByRestaurantId(restaurantId);

        return ResponseEntity.ok(menus);

    }

}
