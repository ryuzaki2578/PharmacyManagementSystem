package com.cognizant.medicalrepresentative.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.medicalrepresentativeschedule.model.RepSchedule;

@SpringBootTest
public class RepScheduleTest {

	private RepSchedule repSchedule;
	
	@Before
	public void setup() {
		
		repSchedule = new RepSchedule();
		repSchedule.setId(1);
		repSchedule.setRepName("Raju Rastogi");
		repSchedule.setDoctorContactNumber("8080080880");
		repSchedule.setMeetingDate(LocalDate.now());
		repSchedule.setMeetingSlot("1 PM to 2 PM");
		repSchedule.setDoctorName("testName");
		repSchedule.setMedicines(new String[]{"testMed"});
		repSchedule.setTreatingAilment("Treating");
	}
	@Test
	public void testSchedule() {
		String []medicine=new String[]{"testMed"};
		assertEquals(repSchedule.toString(),new RepSchedule(1,"Raju Rastogi","testName","1 PM to 2 PM",LocalDate.now(),"8080080880",medicine,"Treating").toString());
	}
}
