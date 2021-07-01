package com.cognizant.pharmacysupply.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.pharmacysupply.model.MedicineStock;

@FeignClient(url = "http://localhost:8081", name = "medicine-stock-service")
public interface MedicineStockFeignClient {

	@PostMapping("/api/medicine-stock/get-stock-count/{medicine}")
	MedicineStock getNumberOfTabletsInStockByName(@RequestHeader(name = "Authorization") String token,
			@PathVariable("medicine") String medicine);

	@PostMapping("/api/medicine-stock/update-stock/{medicine}/{count}")
	Boolean updateNumberOfTabletsInStockByName(@RequestHeader(name = "Authorization") String token,
			@PathVariable("medicine") String medicine, @PathVariable("count") int count);
}
