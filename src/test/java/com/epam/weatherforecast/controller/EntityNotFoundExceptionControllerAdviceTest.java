package com.epam.weatherforecast.controller;

import com.epam.weatherforecast.exception.EntityNotFoundException;
import com.epam.weatherforecast.model.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EntityNotFoundExceptionControllerAdviceTest {

    @Autowired
    private EntityNotFoundExceptionControllerAdvice controllerAdvice;

    @Test
    public void handleEntityNotFoundExceptionMessage() {
        ErrorMessage message = controllerAdvice.handleNotFoundException(new EntityNotFoundException("Entity not found"));
        assertThat(message).hasFieldOrProperty("message");
        assertThat(message.getMessage()).isEqualTo("City not found");
    }
}