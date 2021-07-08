package com.cognizant.medicalrepresentativeschedule;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableFeignClients
@SpringBootApplication
public class MedRepScheduleServiceApplication {
	private static final String ACAO = "Access-Control-Allow-Origin";

	public static void main(String[] args) {
		log.info("Start");

		SpringApplication.run(MedRepScheduleServiceApplication.class, args);
		log.info("End");
	}
}
