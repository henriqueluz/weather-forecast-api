package com.epam.weatherforecast.controller;

import com.epam.weatherforecast.exception.EntityNotFoundException;
import com.epam.weatherforecast.model.Weather;
import com.epam.weatherforecast.service.ForecastService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private ForecastService service;

    public WeatherController(ForecastService service) {
        this.service = service;
    }

    @GetMapping("/weather")
    public ResponseEntity<Weather> getCurrentWeather(@RequestParam("city") String city) throws EntityNotFoundException {
        return ResponseEntity.ok(service.getCurrentWeatherByCity(city));
    }

}
