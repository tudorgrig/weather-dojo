package com.assignment.spring.persistency.relational.repository;

import com.assignment.spring.persistency.relational.entities.WeatherEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends CrudRepository<WeatherEntity, Integer> {
}
