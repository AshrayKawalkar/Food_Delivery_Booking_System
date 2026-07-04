package com.Ashray.food_delivery.Menu.exception;


public class MenuNotFoundException extends RuntimeException{
    public MenuNotFoundException(String message) {
        super(message);
    }
}
