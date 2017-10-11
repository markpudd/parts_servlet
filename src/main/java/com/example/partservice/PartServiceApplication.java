package com.example.partservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//@Configuration
@ComponentScan
@EnableAutoConfiguration
//@EnableEurekaClient
public class PartServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PartServiceApplication.class, args);
    }
}
