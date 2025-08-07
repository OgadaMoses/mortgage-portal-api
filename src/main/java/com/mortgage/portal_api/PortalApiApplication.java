package com.mortgage.portal_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class PortalApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortalApiApplication.class, args);
	}
}
