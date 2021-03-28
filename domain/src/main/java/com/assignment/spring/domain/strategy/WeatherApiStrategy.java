package com.assignment.spring.domain.strategy;

import com.assignment.spring.domain.pojo.Weather;

/**
 * Strategy interface needed for retrieving weather data from third party implementation
 */
public interface WeatherApiStrategy {

    /**
     * Retrieve Weather data  for the given city
     * @param city name of city
     * @return weather data
     */
    Weather retrieveWeather(String city);
}
