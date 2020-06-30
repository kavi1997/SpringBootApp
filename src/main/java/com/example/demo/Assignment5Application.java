package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.builder.SpringApplicationBuilder;
@SpringBootApplication
public class Assignment5Application extends ServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Assignment5Application.class, args);
	}
@Override
      protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
          return builder.sources(Assignment5Application.class);
      }
}
