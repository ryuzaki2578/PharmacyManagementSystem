package com.cognizant.medicalrepresentativeschedule.service;

import static org.junit.Assert.assertThrows;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.medicalrepresentativeschedule.model.Doctor;
import com.cognizant.medicalrepresentativeschedule.model.RepSchedule;

import feign.FeignException;

@RunWith(SpringRunner.class)
@SpringBootTest
class MedRepScheduleServiceImplTest {
	@Rule
    public MockitoRule rule = MockitoJUnit.rule();
	@Autowired
	private MedRepScheduleServiceImpl medicalRepresentativeScheduleService;

	@Mock
	private RepSchedule repSchedule;

	List<Date> scheduleDates;

	List<Doctor> doctorDetailsList;

	@BeforeEach
	public void setup() {
		String[] medicines = { "Crocin", "Percocet" };
		repSchedule = new RepSchedule();
		repSchedule.setId(1);
		repSchedule.setRepName("R1");
		repSchedule.setDoctorName("D1");
		repSchedule.setTreatingAilment("Orthopaedics");
		repSchedule.setMedicines(medicines);
		repSchedule.setMeetingSlot("1 AM to 2 PM");
		repSchedule.setMeetingDate(LocalDate.of(2020, 02, 03));
		repSchedule.setDoctorContactNumber("784521487");
	}

	@Test
	void testGetRepSchedule() throws FeignException {
		LocalDate localDate = LocalDate.of(2020, 2, 2);
		assertThrows(FeignException.class,
				() -> medicalRepresentativeScheduleService.getRepSchedule("token", localDate));

	}

}
