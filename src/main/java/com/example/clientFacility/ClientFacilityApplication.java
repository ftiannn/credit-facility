package com.example.clientFacility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ClientFacilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientFacilityApplication.class, args);
	}

}
