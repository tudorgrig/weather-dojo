package com.assignment.spring.persistency.relational.mapper;

import com.assignment.spring.domain.pojo.Weather;
import com.assignment.spring.persistency.relational.entities.WeatherEntity;
import org.springframework.stereotype.Component;

@Component
public class WeatherEntityMapper {

    public WeatherEntity mapDomainToEntity(Weather weatherDomain) {
        if(weatherDomain == null){
            return null;
        }
        WeatherEntity entity = new WeatherEntity();
        entity.setId(weatherDomain.getId().orElse(null));
        entity.setCity(weatherDomain.getCity());
        entity.setCountry(weatherDomain.getCountry());
        entity.setTemperature(weatherDomain.getTemperature().orElse(null));
        return entity;
    }
}
