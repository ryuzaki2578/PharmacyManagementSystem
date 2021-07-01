package com.cognizant.medicalrepresentativeschedule.service;

import java.util.List;

import com.cognizant.medicalrepresentativeschedule.exception.TokenValidationFailedException;
import com.cognizant.medicalrepresentativeschedule.model.MedicalRepresentative;

public interface MedRepService {
	
	List<MedicalRepresentative> getMedicalRepresentatives(String token) throws TokenValidationFailedException;

}
