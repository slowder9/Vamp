package com.company.Vamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VampApplication {

	public static void main(String[] args) {
		SpringApplication.run(VampApplication.class, args);
	}
}
