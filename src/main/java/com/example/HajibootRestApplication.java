package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class HajibootRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(HajibootRestApplication.class, args);
    }
}
