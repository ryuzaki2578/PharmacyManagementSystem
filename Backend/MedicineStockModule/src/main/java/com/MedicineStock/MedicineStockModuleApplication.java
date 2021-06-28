package com.MedicineStock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@Slf4j
@EnableFeignClients
public class MedicineStockModuleApplication {

	public static void main(String[] args) {
		log.info("Start");
		SpringApplication.run(MedicineStockModuleApplication.class, args);
		log.info("End");
	}

}
