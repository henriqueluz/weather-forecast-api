package com.epam.weatherforecast.service;

import com.epam.weatherforecast.config.AppProperties;
import com.epam.weatherforecast.exception.EntityNotFoundException;
import com.epam.weatherforecast.model.Temperature;
import com.epam.weatherforecast.model.Weather;
import com.epam.weatherforecast.model.dto.OpenWeatherDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.annotations.Cacheable;

@Service
public class OpenWeatherService implements ForecastService {

    private final RestTemplate restTemplate;
    private final AppProperties properties;

    public OpenWeatherService(RestTemplate restTemplate, AppProperties properties) {
        this.restTemplate = restTemplate;
        this.properties = properties;
    }

    @Override
    @Cacheable("weather")
    public Weather getCurrentWeatherByCity(String cityCode) throws EntityNotFoundException {
        try {
        ResponseEntity<OpenWeatherDTO> response = this.restTemplate.getForEntity(properties.getBaseUrl(), OpenWeatherDTO.class, cityCode, properties.getApplicationId(), properties.getUnits());
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
        } catch (HttpClientErrorException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }
}
