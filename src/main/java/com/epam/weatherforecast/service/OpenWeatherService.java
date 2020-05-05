package com.epam.weatherforecast.service;

import com.epam.weatherforecast.model.Weather;
import org.springframework.stereotype.Service;

@Service
public class OpenWeatherService implements ForecastService {

    @Override
    public Weather getCurrentWeatherByCity(String cityCode) {
        return Weather.builder()
                .maxTemperature(32.0)
                .minTemperature(21.7)
                .feelsLike(31.0)
                .pressure(980.0)
                .windSpeed(27.0)
                .build();
    }
}
