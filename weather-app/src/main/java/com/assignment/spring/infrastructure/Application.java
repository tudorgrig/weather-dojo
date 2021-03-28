package com.assignment.spring.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.assignment.spring")
@EnableJpaRepositories(basePackages = "com.assignment.spring.persistency.relational.repository")
@EntityScan(basePackages = "com.assignment.spring.persistency.relational.entities")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
