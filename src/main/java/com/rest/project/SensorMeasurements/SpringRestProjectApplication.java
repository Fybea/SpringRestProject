package com.rest.project.SensorMeasurements;

import com.rest.project.SensorMeasurements.exceptions.ExceptionHandlerController;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringRestProjectApplication extends ExceptionHandlerController {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestProjectApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}