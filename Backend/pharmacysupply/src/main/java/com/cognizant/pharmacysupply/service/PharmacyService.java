package com.cognizant.pharmacysupply.service;

import java.util.List;

import com.cognizant.pharmacysupply.exception.MedicineNotFoundException;
import com.cognizant.pharmacysupply.model.MedicineDemand;
import com.cognizant.pharmacysupply.model.PharmacyMedicineSupply;

public interface PharmacyService {
	Boolean validateToken(String token);

	List<PharmacyMedicineSupply> getMedicineSupply();

	List<MedicineDemand> getMedicineDemand();

	List<PharmacyMedicineSupply> getPharmacySupplyCount(String token, List<MedicineDemand> medicineDemandList)
			throws MedicineNotFoundException;
}
