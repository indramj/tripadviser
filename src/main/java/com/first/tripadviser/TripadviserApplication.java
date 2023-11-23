package com.first.tripadviser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TripadviserApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripadviserApplication.class, args);
	}

}
