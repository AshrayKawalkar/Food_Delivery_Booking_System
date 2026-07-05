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
@RequestMapping("/api/menu")
public class MenuController {


    private final MenuService menuService;


    @PostMapping("/{id}")
    public ResponseEntity<MenuResponse> createMenu(@Valid @PathVariable Long id , @RequestBody CreateMenuRequest request) {

        MenuResponse menuCreate = menuService.createMenu(id, request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(menuCreate);
    }


    @PutMapping("/{id}")
    public ResponseEntity<MenuResponse> updateMenu(@Valid  @PathVariable Long id, @RequestBody UpdateMenuRequest request) {

        MenuResponse response = menuService.updateMenu(id, request);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(response);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {

        menuService.deleteMenu(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<MenuResponse>> getAllMenu() {
        List<MenuResponse> allMenus = menuService.getAllMenus();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(allMenus);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuResponse> getMenuById(@PathVariable Long id) {

        MenuResponse menuById = menuService.getMenuById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(menuById);
    }
}
