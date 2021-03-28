package com.assignment.spring.persistency.relational;

import com.assignment.spring.domain.pojo.Weather;
import com.assignment.spring.persistency.relational.entities.WeatherEntity;
import com.assignment.spring.persistency.relational.mapper.WeatherEntityMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
public class WeatherEntityMapperTest {

    private static final Integer ID = 1;
    private static final String CITY = "CITY";
    private static final String COUNTRY = "COUNTRY";
    private static final Double TEMPERATURE = Double.valueOf(2);
    private final WeatherEntityMapper weatherEntityMapper = new WeatherEntityMapper();

    @Test
    public void shouldMapNullToNull(){
        WeatherEntity weatherEntity = weatherEntityMapper.mapDomainToEntity(null);
        assertNull(weatherEntity);
    }

    @Test
    public void shouldMapValidWeatherDomainToEntity(){
        WeatherEntity weatherEntity = weatherEntityMapper.mapDomainToEntity(createWeatherDomain());
        assertEquals(ID, weatherEntity.getId());
        assertEquals(CITY, weatherEntity.getCity());
        assertEquals(COUNTRY, weatherEntity.getCountry());
        assertEquals(TEMPERATURE, weatherEntity.getTemperature());
    }

    private Weather createWeatherDomain() {
        Weather weather = new Weather(CITY, COUNTRY);
        weather.setId(ID);
        weather.setTemperature(TEMPERATURE);
        return weather;
    }
}
