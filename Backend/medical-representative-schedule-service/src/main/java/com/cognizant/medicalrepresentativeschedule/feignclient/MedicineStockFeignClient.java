package com.cognizant.medicalrepresentativeschedule.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "http://localhost:8081", name = "medicine-stock-service")
public interface MedicineStockFeignClient {

	@GetMapping("/api/medicine-stock/byTreatingAilment/{treatingAilment}")
	 String[] getMedicinesByTreatingAilment(@RequestHeader("Authorization") String token, @PathVariable("treatingAilment") String treatingAilment);

}
