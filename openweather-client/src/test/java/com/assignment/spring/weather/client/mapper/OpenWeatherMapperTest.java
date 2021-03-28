package com.assignment.spring.weather.client.mapper;

import com.assignment.spring.domain.pojo.Weather;
import com.assignment.spring.weather.client.api.WeatherResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.assignment.spring.weather.client.TestDataBuilder.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
public class OpenWeatherMapperTest {

    private final OpenWeatherMapper openWeatherMapper = new OpenWeatherMapper();

    @Test
    public void shouldMapNullToNull(){
        Weather weather = openWeatherMapper.mapApiToDomain(null);
        assertNull(weather);
    }

    @Test
    public void shouldMapValidResponseToDomain(){
        WeatherResponse weatherResponse = createWeatherResponse();
        Weather weather = openWeatherMapper.mapApiToDomain(weatherResponse);
        assertEquals(CITY, weather.getCity());
        assertEquals(COUNTRY, weather.getCountry());
        assertEquals(TEMPERATURE, weather.getTemperature().get());
    }
}
