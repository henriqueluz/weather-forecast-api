package com.epam.weatherforecast.controller;

import com.epam.weatherforecast.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MissingRequiredParameterControllerAdvice {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleNotFoundException(MissingServletRequestParameterException e) {
        return ErrorMessage.builder()
                .message(e.getMessage())
                .build();
    }

}
