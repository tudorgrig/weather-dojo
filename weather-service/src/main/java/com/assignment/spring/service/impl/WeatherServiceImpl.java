package com.assignment.spring.service.impl;

import com.assignment.spring.domain.pojo.Weather;
import com.assignment.spring.domain.strategy.WeatherApiStrategy;
import com.assignment.spring.persistency.relational.entities.WeatherEntity;
import com.assignment.spring.persistency.relational.mapper.WeatherEntityMapper;
import com.assignment.spring.persistency.relational.repository.WeatherRepository;
import com.assignment.spring.service.WeatherService;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl extends WeatherService {

    private WeatherEntityMapper weatherEntityMapper;

    private WeatherRepository weatherRepository;

    public WeatherServiceImpl(WeatherApiStrategy weatherApiStrategy, WeatherEntityMapper weatherEntityMapper,
                              WeatherRepository weatherRepository){
        super(weatherApiStrategy);
        this.weatherEntityMapper = weatherEntityMapper;
        this.weatherRepository = weatherRepository;
    }

    @Override
    public Weather processWeather(String city) {
        Weather weatherDomain = getWeatherApiStrategy().retrieveWeather(city);
        WeatherEntity weatherEntity = weatherEntityMapper.mapDomainToEntity(weatherDomain);
        weatherRepository.save(weatherEntity);
        weatherDomain.setId(weatherEntity.getId());
        return weatherDomain;
    }
}
