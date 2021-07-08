package com.cognizant.authorization;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class AuthorizationServiceApplication {

	public static void main(String[] args) {
		log.debug("START");
		SpringApplication.run(AuthorizationServiceApplication.class, args);
		log.debug("END");
	}

}
