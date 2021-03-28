package com.assignment.spring.domain.service;

import com.assignment.spring.domain.pojo.Weather;

/**
 * Service class for business requirements regarding weather
 */
public abstract class WeatherService {

    private final WeatherApiStrategy weatherApiStrategy;

    protected WeatherService(WeatherApiStrategy weatherApiStrategy){
        this.weatherApiStrategy = weatherApiStrategy;
    }

    /**
     * For a  given city, retrieve weather and process it
     * @param city city name
     * @return weather data
     */
    public abstract Weather processWeather(String city);

    protected WeatherApiStrategy getWeatherApiStrategy() {
        return weatherApiStrategy;
    }
}
