package com.assignment.spring.weather.client.mapper;

import com.assignment.spring.domain.pojo.Weather;
import com.assignment.spring.weather.client.api.WeatherResponse;
import org.springframework.stereotype.Component;

/**
 * Mapper for converting Open Weather response object {@link com.assignment.spring.weather.client.api.WeatherResponse}
 * to domain Weather object {@link com.assignment.spring.domain.pojo.Weather}
 */
@Component
public class OpenWeatherMapper {

    public Weather mapApiToDomain(WeatherResponse weatherResponse){
        if(weatherResponse == null){
            return null;
        }
        Weather weatherDomain = new Weather(weatherResponse.getName(),
                weatherResponse.getSys().getCountry());
        weatherDomain.setTemperature(weatherResponse.getMain().getTemp());
        return weatherDomain;
    }
}
