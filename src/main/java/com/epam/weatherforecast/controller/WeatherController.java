package com.epam.weatherforecast.controller;

import com.epam.weatherforecast.exception.EntityNotFoundException;
import com.epam.weatherforecast.model.Weather;
import com.epam.weatherforecast.service.ForecastService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private ForecastService service;

    @GetMapping("/weather")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get current weather for a given city"),
            @ApiResponse(code = 404, message = "City not found"),
    })
    public ResponseEntity<Weather> getCurrentWeather(@RequestParam("city") String city) throws EntityNotFoundException {
        return ResponseEntity.ok(service.getCurrentWeatherByCity(city));
    }

    public WeatherController(ForecastService service) {
        this.service = service;
    }

}
