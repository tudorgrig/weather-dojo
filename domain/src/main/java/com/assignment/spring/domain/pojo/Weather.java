package com.assignment.spring.domain.pojo;

import java.util.Optional;

/**
 * Domain object for all weather data required by business features
 */
public class Weather {

    private Integer id;

    private String city;

    private String country;

    private Double temperature;

    public Weather(String city, String country){
        this.city = city;
        this.country = country;
    }

    public Optional<Integer> getId() {
        return Optional.ofNullable(id);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Optional<Double> getTemperature() {
        return Optional.ofNullable(temperature);
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
