package com.assignment.spring.weather.client.strategy;

import com.assignment.spring.domain.pojo.Weather;
import com.assignment.spring.domain.service.WeatherApiStrategy;
import com.assignment.spring.weather.client.api.WeatherResponse;
import com.assignment.spring.weather.client.mapper.OpenWeatherMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotBlank;

/**
 * Open Weather specific implementation of the strategy pattern interface
 */
@Component
public class OpenWeatherStrategy implements WeatherApiStrategy {

    private RestTemplate restTemplate;

    private OpenWeatherMapper weatherMapper;

    @Value("${weather.api.url}")
    private String weatherApiUrl;

    @Value("${weather.api.appid}")
    private String weatherApiAppId;

    public OpenWeatherStrategy(RestTemplate restTemplate, OpenWeatherMapper openWeatherMapper){
        this.restTemplate = restTemplate;
        this.weatherMapper = openWeatherMapper;
    }

    @Override
    public Weather retrieveWeather(@NotBlank String city) {
        String url = weatherApiUrl.replace("{city}", city).replace("{appid}", weatherApiAppId);
        try {
            ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(url, WeatherResponse.class);
            return weatherMapper.mapApiToDomain(response.getBody());
        } catch(HttpClientErrorException.NotFound notFoundException){
            throw new IllegalArgumentException("City " + city + " not found", notFoundException);
        }
    }
}
