package com.assignment.spring.weather.client;

import com.assignment.spring.weather.client.api.Main;
import com.assignment.spring.weather.client.api.Sys;
import com.assignment.spring.weather.client.api.WeatherResponse;

public class TestDataBuilder {

    public static final String CITY = "Bucharest";
    public static final String COUNTRY = "Romania";
    public static final Double TEMPERATURE = Double.valueOf(279);

    public static WeatherResponse createWeatherResponse() {
        WeatherResponse weatherResponse = new WeatherResponse();
        Sys sys = new Sys();
        sys.setCountry(COUNTRY);
        Main main = new Main();
        main.setTemp(TEMPERATURE);
        weatherResponse.setName(CITY);
        weatherResponse.setSys(sys);
        weatherResponse.setMain(main);
        return weatherResponse;
    }
}
