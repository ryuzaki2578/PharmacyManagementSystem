package com.cognizant.pharmacysupply.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.pharmacysupply.exception.MedicineNotFoundException;
import com.cognizant.pharmacysupply.exception.TokenValidationFailedException;
import com.cognizant.pharmacysupply.model.MedicineDemand;
import com.cognizant.pharmacysupply.model.PharmacyMedicineSupply;
import com.cognizant.pharmacysupply.service.PharmacyServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
public class PharmacyController {
	
	@Autowired
	private PharmacyServiceImpl pharmacyService;
	
	@PostMapping("/pharmacy-supply")
	public ResponseEntity<List<PharmacyMedicineSupply>> getPharmacySupply(@RequestHeader(name = "Authorization") String token,
			@Valid @RequestBody List<MedicineDemand> medicineDemandList) throws MedicineNotFoundException {
		log.info("Start");

		log.debug("medicineDemandList {}:", medicineDemandList);
		List<PharmacyMedicineSupply> pharmacySupply = null;
		if (pharmacyService.validateToken(token)) {
			pharmacySupply = pharmacyService.getPharmacySupplyCount(token, medicineDemandList);
			
			if (pharmacySupply == null)  {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			
			log.info("End");
			return new ResponseEntity<>(pharmacySupply, HttpStatus.OK);
		}
		log.info("End");
		throw new TokenValidationFailedException("Token is no longer valid");
	}


	@GetMapping("/getMedicineSupply")
	public ResponseEntity<List<PharmacyMedicineSupply>> getMedicineSupply(@RequestHeader("Authorization") String token) {
		List<PharmacyMedicineSupply> medicineSupply = null;
		if (pharmacyService.validateToken(token)) {
			medicineSupply = pharmacyService.getMedicineSupply();
			return new ResponseEntity<>(medicineSupply, HttpStatus.OK);
		}
		throw new TokenValidationFailedException("Token is no longer valid");
	}
	
	@GetMapping("/getMedicineDemand")
	public ResponseEntity<List<MedicineDemand>> getMedicineDemand(@RequestHeader(name = "Authorization") String token) {
		List<MedicineDemand> medicineDemand = null;
		if (pharmacyService.validateToken(token)) {
			medicineDemand = pharmacyService.getMedicineDemand();
			return new ResponseEntity<>(medicineDemand, HttpStatus.OK);
		}
		throw new TokenValidationFailedException("Token is no longer valid");
	}

}
