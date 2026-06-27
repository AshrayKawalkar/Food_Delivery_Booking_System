package com.Ashray.food_delivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.logging.ErrorManager;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleEmailExist(EmailAlreadyExistsException ex) {

        ErrorResponse error= new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                ex.getMessage()

        );

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}
