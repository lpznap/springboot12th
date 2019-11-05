package com.example.springboot12th;

import com.example.springboot12th.domain.Employee;
import com.example.springboot12th.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springboot12thApplication {

	@Bean
	public CommandLineRunner init(EmployeeRepository repository){
		return (args -> {
			repository.save(new Employee("MJ","Carter"));
			repository.save(new Employee("Beater","Heart"));
			repository.save(new Employee("Ojo","Dulan"));
			repository.save(new Employee("Joseph","Joestar"));
		});
	}

	public static void main(String[] args) {
		SpringApplication.run(Springboot12thApplication.class, args);
	}

}
