package com.cognizant.pharmacysupply.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.pharmacysupply.exception.MedicineNotFoundException;
import com.cognizant.pharmacysupply.exception.TokenValidationFailedException;
import com.cognizant.pharmacysupply.feignclient.AuthenticationFeignClient;
import com.cognizant.pharmacysupply.feignclient.MedicineStockFeignClient;
import com.cognizant.pharmacysupply.model.JwtResponse;
import com.cognizant.pharmacysupply.model.MedicineDemand;
import com.cognizant.pharmacysupply.model.MedicineStock;
import com.cognizant.pharmacysupply.model.PharmacyMedicineSupply;
import com.cognizant.pharmacysupply.repository.MedicineDemandRepository;
import com.cognizant.pharmacysupply.repository.PharmacyMedicineSupplyRepository;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PharmacyServiceImpl implements PharmacyService {
	@Autowired
	private MedicineDemandRepository medicineDemandRepo;

	@Autowired
	private MedicineStockFeignClient stockFeignClient;

	@Autowired
	private PharmacyMedicineSupplyRepository pharmacyMedicineSupplyRepository;

	@Autowired
	private AuthenticationFeignClient authFeign;

	@Autowired
	private MedicineDemandRepository medicineDemandRepository;

	@Override
	public List<PharmacyMedicineSupply> getPharmacySupplyCount(String token, List<MedicineDemand> medicineDemandList)
			throws MedicineNotFoundException {
		List<PharmacyMedicineSupply> list = new ArrayList<>();
		List<PharmacyMedicineSupply> nullList = null;
		for (MedicineDemand medicineDemand : medicineDemandList) {
			MedicineStock medicineStock = getNumberOfTablets(token, medicineDemand);
			log.info("{}", medicineStock);
			log.info("Medicine {} , Tablets {}", medicineDemand.getMedicineName(),
					medicineStock.getNumberOfTabletsInStock());

		
			PharmacyMedicineSupply pharmacyMedicineSupply = new PharmacyMedicineSupply();

			setSupply(token, pharmacyMedicineSupply, medicineDemand, medicineStock);
			list.add(pharmacyMedicineSupply);
		}
		pharmacyMedicineSupplyRepository.saveAll(list);
		medicineDemandRepository.saveAll(medicineDemandList);
		log.info("End");
		return list;
	}

	public void setSupply(String token, PharmacyMedicineSupply medicineSupply, MedicineDemand medicineDemand,
			MedicineStock medicineStock) throws MedicineNotFoundException {
		log.info("Start");
		int val = 0;
		log.info("number of tablets {}", medicineStock.getNumberOfTabletsInStock());
		if (medicineStock.getNumberOfTabletsInStock() < medicineDemand.getDemandCount()) {
			medicineSupply.setSupplyCount(medicineStock.getNumberOfTabletsInStock());

		} else {
			medicineSupply.setSupplyCount(medicineDemand.getDemandCount());
			val = medicineStock.getNumberOfTabletsInStock() - medicineDemand.getDemandCount();

		}
		//log.info("val = {}", val);
		try {
			log.info("val={}",val);
			stockFeignClient.updateNumberOfTabletsInStockByName(token, medicineDemand.getMedicineName(),val);
		} catch (FeignException ex) {
			throw new MedicineNotFoundException("Medicine not found");
		}
		medicineSupply.setMedicineName(medicineDemand.getMedicineName());
		log.info("medicineDemand {} medicineSupply {}", medicineDemand, medicineSupply);
		medicineSupply.setPharmacyName(medicineStock.getPharmacyName());
		log.info("medicineSupply{}:", medicineSupply);
		log.info("End");
	}

	public MedicineStock getNumberOfTablets(String token, MedicineDemand medicineDemand)
			throws MedicineNotFoundException {
		log.info("Start");
		MedicineStock medicineStock = null;
		log.info("Medicine : {}", medicineDemand.toString());
		try {
			medicineStock = stockFeignClient.getNumberOfTabletsInStockByName(token, medicineDemand.getMedicineName());
		} catch (FeignException ex) {
			throw new MedicineNotFoundException("Medicine not found");
		}

		if (medicineStock == null) {
			throw new MedicineNotFoundException("Medicine not found");
		}
		log.info("End");
		return medicineStock;
	}

	@Override
	public List<MedicineDemand> getMedicineDemand() {
		log.info("Start");
		return medicineDemandRepo.findAll();
	}

	@Override
	public List<PharmacyMedicineSupply> getMedicineSupply() {
		log.info("Start");
		return pharmacyMedicineSupplyRepository.findAll();
	}

	@Override
	public Boolean validateToken(String token) {
		log.info("Start");

		JwtResponse jwtResponse = authFeign.verifyToken(token);
		log.info("End");

		if (jwtResponse.isValid()) {
			return true;
		}
		throw new TokenValidationFailedException("Token is no longer valid");

	}
}
