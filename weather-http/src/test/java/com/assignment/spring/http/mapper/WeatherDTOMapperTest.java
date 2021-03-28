package com.assignment.spring.http.mapper;

import com.assignment.spring.domain.pojo.Weather;
import com.assignment.spring.http.dto.WeatherDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
public class WeatherDTOMapperTest {

    private static final String CITY = "CITY";
    private static final String COUNTRY = "COUNTRY";
    private static final Integer ID = 2;
    private static final Double TEMPERATURE = Double.valueOf(200);

    private final WeatherDTOMapper weatherDTOMapper = new WeatherDTOMapper();

    @Test
    public void shouldMapNullToNull(){
        WeatherDTO weatherDTO = weatherDTOMapper.mapDomainToDTO(null);
        assertNull(weatherDTO);
    }

    @Test
    public void shouldMapValidDomain(){
        WeatherDTO weatherDTO = weatherDTOMapper.mapDomainToDTO(createDomain());
        assertEquals(ID, weatherDTO.getId());
        assertEquals(CITY, weatherDTO.getCity());
        assertEquals(COUNTRY, weatherDTO.getCountry());
        assertEquals(TEMPERATURE, weatherDTO.getTemperature());
    }

    private Weather createDomain() {
        Weather weather = new Weather(CITY, COUNTRY);
        weather.setId(ID);
        weather.setTemperature(TEMPERATURE);
        return weather;
    }
}
