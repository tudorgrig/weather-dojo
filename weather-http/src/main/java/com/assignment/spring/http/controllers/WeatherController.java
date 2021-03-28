package com.assignment.spring.http.controllers;

import com.assignment.spring.domain.pojo.Weather;
import com.assignment.spring.http.dto.WeatherDTO;
import com.assignment.spring.http.mapper.WeatherDTOMapper;
import com.assignment.spring.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class WeatherController {

    private WeatherDTOMapper weatherMapper;

    private WeatherService weatherService;

    public WeatherController(WeatherDTOMapper weatherMapper,
                             WeatherService weatherService){
        this.weatherMapper = weatherMapper;
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public ResponseEntity<WeatherDTO> processWeatherForCity(@RequestParam("city") String city) {
        try {
            Weather weatherDomain = weatherService.processWeather(city);
            return ResponseEntity.ok(weatherMapper.mapDomainToDTO(weatherDomain));
        } catch (IllegalArgumentException illegalArgumentException){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, illegalArgumentException.getMessage(), illegalArgumentException);
        }
    }


}
