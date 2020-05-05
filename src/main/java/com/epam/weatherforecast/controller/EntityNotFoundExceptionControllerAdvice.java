package com.epam.weatherforecast.controller;

import com.epam.weatherforecast.exception.EntityNotFoundException;
import com.epam.weatherforecast.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EntityNotFoundExceptionControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleNotFoundException(EntityNotFoundException e) {
        return ErrorMessage.builder()
                .message("City not found")
                .build();
    }
}
