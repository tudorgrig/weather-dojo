package com.assignment.spring.service;

import com.assignment.spring.domain.pojo.Weather;
import com.assignment.spring.domain.strategy.WeatherApiStrategy;
import com.assignment.spring.persistency.relational.entities.WeatherEntity;
import com.assignment.spring.persistency.relational.mapper.WeatherEntityMapper;
import com.assignment.spring.persistency.relational.repository.WeatherRepository;
import com.assignment.spring.service.impl.WeatherServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WeatherServiceImplTest {

    private final static  String CITY = "CITY";

    @Mock
    private WeatherEntityMapper weatherEntityMapper;

    @Mock
    private WeatherRepository weatherRepository;

    @Mock
    private WeatherApiStrategy weatherApiStrategy;

    @InjectMocks
    private WeatherServiceImpl weatherServiceImpl;

    @Test
    public void shouldProcessCity(){
        Weather weather = mock(Weather.class);
        WeatherEntity weatherEntity = mock(WeatherEntity.class);
        when(weatherApiStrategy.retrieveWeather(CITY)).thenReturn(weather);
        when(weatherEntityMapper.mapDomainToEntity(weather)).thenReturn(weatherEntity);
        Weather weatherResult = weatherServiceImpl.processWeather(CITY);
        assertEquals(weather, weatherResult);
        verify(weatherRepository).save(weatherEntity);
    }
}
