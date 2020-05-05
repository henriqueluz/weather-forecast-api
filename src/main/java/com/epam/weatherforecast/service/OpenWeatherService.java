package com.epam.weatherforecast.service;

import com.epam.weatherforecast.model.Temperature;
import com.epam.weatherforecast.model.Weather;
import org.springframework.stereotype.Service;

@Service
public class OpenWeatherService implements ForecastService {

    @Override
    public Weather getCurrentWeatherByCity(String cityCode) {
        return Weather.builder()
                .temperature(Temperature.builder()
                                .max(31.2)
                                .min(20.7)
                                .feelsLike(28.9)
                                .build())
                .pressure(980.0)
                .windSpeed(27.0)
                .build();
    }
}
