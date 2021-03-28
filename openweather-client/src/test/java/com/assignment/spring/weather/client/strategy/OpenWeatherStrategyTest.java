package com.assignment.spring.weather.client.strategy;

import com.assignment.spring.weather.client.api.WeatherResponse;
import com.assignment.spring.weather.client.mapper.OpenWeatherMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static com.assignment.spring.weather.client.TestDataBuilder.CITY;
import static com.assignment.spring.weather.client.TestDataBuilder.createWeatherResponse;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OpenWeatherStrategyTest {

    private static final String APP_ID = "APP_ID";
    private static final String WEATHER_API_URL = "WEATHER_API_URL";

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private OpenWeatherMapper openWeatherMapper;

    @InjectMocks
    private OpenWeatherStrategy openWeatherStrategy;


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForInvalidCityName(){
        HttpClientErrorException.NotFound notFound = mock(HttpClientErrorException.NotFound.class);
        ReflectionTestUtils.setField(openWeatherStrategy, "weatherApiUrl",WEATHER_API_URL);
        ReflectionTestUtils.setField(openWeatherStrategy, "weatherApiAppId",APP_ID);
        when(restTemplate.getForEntity(WEATHER_API_URL, WeatherResponse.class))
                .thenThrow(notFound);
        openWeatherStrategy.retrieveWeather(CITY);
    }

    @Test
    public void shouldRetrieveValidWeather(){

        ReflectionTestUtils.setField(openWeatherStrategy, "weatherApiUrl",WEATHER_API_URL);
        ReflectionTestUtils.setField(openWeatherStrategy, "weatherApiAppId",APP_ID);

        WeatherResponse weatherResponse = createWeatherResponse();
        when(restTemplate.getForEntity(WEATHER_API_URL, WeatherResponse.class))
                .thenReturn(ResponseEntity.of(Optional.of(weatherResponse)));
        openWeatherStrategy.retrieveWeather(CITY);
        verify(openWeatherMapper).mapApiToDomain(weatherResponse);
    }
}
