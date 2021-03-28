package com.assignment.spring.http.mapper;

import com.assignment.spring.domain.pojo.Weather;
import com.assignment.spring.http.dto.WeatherDTO;
import org.springframework.stereotype.Component;

@Component
public class WeatherDTOMapper {

    public WeatherDTO mapDomainToDTO(Weather weather) {
        if(weather == null){
            return null;
        }
        WeatherDTO weatherDTO = new WeatherDTO();
        weatherDTO.setId(weather.getId().orElse(null));
        weatherDTO.setTemperature(weather.getTemperature().orElse(null));
        weatherDTO.setCountry(weather.getCountry());
        weatherDTO.setCity(weather.getCity());
        return weatherDTO;
    }
}
