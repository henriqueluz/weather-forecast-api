package com.epam.weatherforecast.service;

import com.epam.weatherforecast.model.Weather;

public interface ForecastService {
    Weather getCurrentWeatherByCity(String cityCode);
}
