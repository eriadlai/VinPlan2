package com.narval;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.narval.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {
		UserRepository.class
		})
public class VinPlanApplication {

	public static void main(String[] args) {
		SpringApplication.run(VinPlanApplication.class, args);
	}

}
