package com.epam.weatherforecast.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Temperature {

    private final Double min;
    private final Double max;
    private final Double feelsLike;

}
