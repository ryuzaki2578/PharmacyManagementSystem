package com.cognizant.medicalrepresentativeschedule.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.medicalrepresentativeschedule.exception.InvalidDateException;
import com.cognizant.medicalrepresentativeschedule.exception.TokenValidationFailedException;
import com.cognizant.medicalrepresentativeschedule.feignclient.AuthenticationFeignClient;
import com.cognizant.medicalrepresentativeschedule.model.JwtResponse;
import com.cognizant.medicalrepresentativeschedule.model.RepSchedule;
import com.cognizant.medicalrepresentativeschedule.service.MedRepScheduleServiceImpl;

@RunWith(SpringRunner.class)
class MedRepScheduleControllerTest {

	@Mock
	private MedRepScheduleServiceImpl medicalRepresentativeScheduleService;

	@Mock
	private AuthenticationFeignClient authenticationFeignClient;

	@InjectMocks
	private MedRepScheduleController medicalRepresenativeScheduleController;

	@Mock
	private RepSchedule repSchedule;

	@Mock
	private List<RepSchedule> medicineStockList;

	@MockBean
	private MedRepScheduleServiceImpl scheduleService;
	
	@BeforeEach
	public void initMock() {
		MockitoAnnotations.initMocks(this);
	}

	public List<RepSchedule> getMockRepSchedule() {
		List<RepSchedule> repSchedules = new ArrayList<>();
		String[] medicines = { "Crocin", "Percocet" };

		RepSchedule mockRepSchedule = new RepSchedule();
		mockRepSchedule.setId(1);
		mockRepSchedule.setDoctorName("D1");
		mockRepSchedule.setMeetingSlot("1 PM to 2 PM");
		mockRepSchedule.setMeetingDate(LocalDate.of(2022, 04, 20));
		mockRepSchedule.setDoctorContactNumber("9449569825");
		mockRepSchedule.setMedicines(medicines);
		repSchedules.add(mockRepSchedule);

		return repSchedules;
	}

	@Test
	 public void retrieveDetailsForCourse() throws InvalidDateException, TokenValidationFailedException {

		when(authenticationFeignClient.verifyToken("token")).thenReturn(new JwtResponse("admin", "admin", true));
		ResponseEntity<?> allMedicineStockInformation = medicalRepresenativeScheduleController.getRepSchedule("token", "20-02-2020");
		assertNotNull(allMedicineStockInformation);

	}

	@Test
	 public void testGetRepScheduleFails() throws InvalidDateException, TokenValidationFailedException {
		when(authenticationFeignClient.verifyToken("token")).thenReturn(new JwtResponse("admin", "admin", false));
		TokenValidationFailedException except=assertThrows(TokenValidationFailedException.class,()->medicalRepresenativeScheduleController.getRepSchedule("token", "20-02-2020"));
		assertTrue(except.getMessage().contains("Invalid Token"));
	}

	
}
