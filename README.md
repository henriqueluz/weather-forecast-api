# Weather Forecast API
##### A simple and slight Java API implementation for weather forecasts

![Java CI](https://github.com/henriqueluz/weather-forecast-api/workflows/Java%20CI/badge.svg)

Operations and transactions provided by this API:

- Weather forecast by city code

## How To

### Start and Run app locally
After cloning source code to your local machine and at project's root dir:

`
$ mvn clean spring-boot:run
`

Application is started by embedded tomcat and your local server will look like that:
http://localhost:8080

### Running tests
There are unit tests for the services and integration tests for repositories using DBUnit
framework. To run those tests just execute:

`$ mvn test`

### Using Weather Forecast API
You can run and use the API locally as much as you can just sending REST requests 
to your local server or you can also use the server that has been deployed on Heroku at
https://openweather-forecast.herokuapp.com/

Please check API docs provided by Swagger from: http://<YOUR_SERVER>/swagger-ui.html		
		
## Tech stack
1. Java 8
2. Maven 3.6
3. SpringBoot 2.2.6
    1. SpringFox Swagger
    2. SpringMVC
    3. SpringSecurity
    4. SpringBoot Caching
 4. JUnit 5
 5. Git
 5. Github CI
 6. Heroku
