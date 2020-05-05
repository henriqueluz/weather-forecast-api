package com.epam.weatherforecast.controller;

import com.epam.weatherforecast.model.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.MissingServletRequestParameterException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MissingRequiredParameterControllerAdviceTest {

    @Autowired
    private MissingRequiredParameterControllerAdvice controllerAdvice;

    @Test
    public void handleMissingRequiredParameterExceptionMessage() {
        ErrorMessage message = controllerAdvice.handleNotFoundException(new MissingServletRequestParameterException("city", "String"));
        assertThat(message).hasFieldOrProperty("message");
        assertThat(message.getMessage()).contains("'city' is not present");
    }

}