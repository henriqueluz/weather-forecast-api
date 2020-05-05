package com.epam.weatherforecast.service;

import com.epam.weatherforecast.model.Weather;
import com.epam.weatherforecast.model.dto.MainDTO;
import com.epam.weatherforecast.model.dto.OpenWeatherDTO;
import com.epam.weatherforecast.model.dto.WindDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
public class OpenWeatherServiceTest {

    private final static String API_URL = "https://api.openweathermap.org/data/";
    private final static String API_VERSION = "2.5";
    private final static String APPLICATION_ID = "d33f86f13c3240f09b02490ba43808b6";
    private final static String UNITS = "metric";
    private final static String RESOURCE = String.format("/weather?id={id}&appid=%s&units=%s", APPLICATION_ID, UNITS);
    private final static String BASE_URL = API_URL + API_VERSION + RESOURCE;

    @Mock
    private RestTemplate template;

    @InjectMocks
    private OpenWeatherService service;

    @Test
    public void getCurrentWeatherByGivenValidCityCode() {
        final Double maxTemperature = 30.0;
        final Double minTemperature = 20.0;
        final Double pressure = 980.0;
        final Double windSpeed = 7.5;
        final Double feelsLike = 28.0;
        final String cityCode = "3094802";
        final OpenWeatherDTO body = OpenWeatherDTO.builder()
                                        .main(MainDTO.builder()
                                                    .maxTemperature(maxTemperature)
                                                    .minTemperature(minTemperature)
                                                    .feelsLike(feelsLike)
                                                    .pressure(pressure)
                                                    .build())
                                        .wind(WindDTO.builder().speed(windSpeed).build())
                                        .build();
        final ResponseEntity<OpenWeatherDTO> response = ResponseEntity.ok(body);

        when(template.getForEntity(BASE_URL, OpenWeatherDTO.class, cityCode)).thenReturn(response);

        final Weather weather = service.getCurrentWeatherByCity(cityCode);

        assertThat(weather.getWindSpeed()).isEqualTo(windSpeed);
    }

}