package com.cognizant.medicinestock.service;

import java.util.List;

import com.cognizant.medicinestock.model.MedicineStock;

public interface MedicineStockService {

	List<MedicineStock> getMedicineStockInformation();

	List<MedicineStock> getMedicineByTargetAilment(String treatingAilment);

	MedicineStock getNumberOfTabletsInStockByName(String medicine);

	Boolean updateNumberOfTabletsInStockByName(String medicine, int count);
}
