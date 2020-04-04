package com.example.springboot;

import com.example.springboot.domain.Employee;
import com.example.springboot.repository.EmployeeJpaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	// Create new bean
	@Bean
	// CommandLineRunner is like initial ENV when bootstrap
	public CommandLineRunner init(EmployeeJpaRepository repository) {
		return (args -> {
			repository.save(new Employee("John", "Doe"));
			repository.save(new Employee("Sam", "Sri"));
			repository.save(new Employee("Kao", "Win"));
		});
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
