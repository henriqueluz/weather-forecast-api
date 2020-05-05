package com.epam.weatherforecast.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Weather {

    private final Double minTemperature;
    private final Double maxTemperature;
    private final Double feelsLike;
    private final Double pressure;
    private final Double windSpeed;
    
}
