package com.epam.weatherforecast.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@AllArgsConstructor
@ConfigurationProperties(prefix = "api")
public class AppProperties {

    private final String host;
    private final String version;
    private final String applicationId;
    private final String units;
    private final String resource;

    public String getBaseUrl() {
        return host + version + resource;
    }

}
