package com.epam.weatherforecast.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Weather {

    private Temperature temperature;
    private final Double pressure;
    private final Double windSpeed;
    
}
