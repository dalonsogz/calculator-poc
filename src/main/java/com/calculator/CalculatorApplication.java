package com.calculator;

import io.corp.calculator.TracerImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.calculator")
public class CalculatorApplication {

    @Bean
    public TracerImpl tracerImpl() {
        return new TracerImpl();
    }

    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
    }

}
