package com.example.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	// Create new bean
	@Bean
	public CommandLineRunner init() {
		return (args -> {

		});
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
