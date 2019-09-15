package com.examples.microservices.webappserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootApplication
public class WebApplication {
	public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}