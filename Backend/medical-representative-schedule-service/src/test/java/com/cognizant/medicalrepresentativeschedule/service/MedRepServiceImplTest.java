package com.cognizant.medicalrepresentativeschedule.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.medicalrepresentativeschedule.exception.TokenValidationFailedException;
import com.cognizant.medicalrepresentativeschedule.feignclient.AuthenticationFeignClient;
import com.cognizant.medicalrepresentativeschedule.model.JwtResponse;
import com.cognizant.medicalrepresentativeschedule.model.MedicalRepresentative;
import com.cognizant.medicalrepresentativeschedule.model.RepSchedule;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
class MedRepServiceImplTest {

	@Mock
	private MedRepServiceImpl medicalRepresentativeService;

	@Mock
	private AuthenticationFeignClient authenticationFeignClient;

	@Mock
	private RepSchedule repSchedule;

	private List<MedicalRepresentative> medicalRepresentatives = new ArrayList<>();

	@Mock
	private List<RepSchedule> medicineStockList;

	@BeforeEach
	public void initMock() {
		MockitoAnnotations.initMocks(this);
	}

	@BeforeEach
	public void setup() {
		medicalRepresentatives.add(new MedicalRepresentative(1, "testRep", "100019281"));
		medicalRepresentatives.add(new MedicalRepresentative(2, "testRep2", "100019282"));
		medicalRepresentatives.add(new MedicalRepresentative(3, "testRep3", "100019283"));
	}

	@Test
	public void testGetMedicalRepresentatives() throws TokenValidationFailedException {

		log.info("Start of testGetMedicalRepresentative");

		when(authenticationFeignClient.verifyToken("token")).thenReturn(new JwtResponse("1", "admin", true));
		log.info("this is {}", medicalRepresentativeService.getMedicalRepresentatives("token"));

		//when(medicalRepresentativeService.getMedicalRepresentatives("token")).thenReturn(medicalRepresentatives);

		List<MedicalRepresentative> medicalRepresentatives = medicalRepresentativeService
				.getMedicalRepresentatives("token");
		assertNotNull(medicalRepresentatives);

	}

	

}
