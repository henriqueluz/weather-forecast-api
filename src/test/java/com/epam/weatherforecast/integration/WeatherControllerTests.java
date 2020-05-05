package com.epam.weatherforecast.integration;

import com.epam.weatherforecast.controller.WeatherController;
import com.epam.weatherforecast.exception.EntityNotFoundException;
import com.epam.weatherforecast.model.Temperature;
import com.epam.weatherforecast.model.Weather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class WeatherControllerTests {

    @Autowired
    private WeatherController controller;

    @Test
    public void loadsContext() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void getCurrentWeatherByCity() throws EntityNotFoundException {
        ResponseEntity<Weather> response = controller.getCurrentWeather("3094802");
        Weather currentWeather = response.getBody();
        Temperature temperature = currentWeather.getTemperature();

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(currentWeather.getWindSpeed()).isNotNull();
        assertThat(currentWeather.getPressure()).isNotNull();
        assertThat(temperature.getMax()).isNotNull();
        assertThat(temperature.getMin()).isNotNull();
        assertThat(temperature.getFeelsLike()).isNotNull();
    }

    @Test
    public void getNotFoundEntityMessageForInvalidCity()  {
        Assertions.assertThrows(EntityNotFoundException.class, () -> controller.getCurrentWeather("INVALID"));
    }

}
