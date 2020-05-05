package com.epam.weatherforecast.service;

import com.epam.weatherforecast.model.Temperature;
import com.epam.weatherforecast.model.Weather;
import com.epam.weatherforecast.model.dto.OpenWeatherDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherService implements ForecastService {

    private final RestTemplate restTemplate;
    private final static String API_URL = "https://api.openweathermap.org/data/";
    private final static String API_VERSION = "2.5";
    private final static String APPLICATION_ID = "d33f86f13c3240f09b02490ba43808b6";
    private final static String UNITS = "metric";
    private final static String RESOURCE = "/weather?id={cityId}&appid={appId}&units={units}";
    private final static String BASE_URL = API_URL + API_VERSION + RESOURCE;

    public OpenWeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Weather getCurrentWeatherByCity(String cityCode) {
        ResponseEntity<OpenWeatherDTO> response = this.restTemplate.getForEntity(BASE_URL, OpenWeatherDTO.class, cityCode, APPLICATION_ID, UNITS);
        OpenWeatherDTO currentWeather = response.getBody();

        return Weather.builder()
                .temperature(Temperature.builder()
                                .max(currentWeather.getMain().getMaxTemperature())
                                .min(currentWeather.getMain().getMinTemperature())
                                .feelsLike(currentWeather.getMain().getFeelsLike())
                                .build())
                .pressure(currentWeather.getMain().getPressure())
                .windSpeed(currentWeather.getWind().getSpeed())
                .build();
    }
}
