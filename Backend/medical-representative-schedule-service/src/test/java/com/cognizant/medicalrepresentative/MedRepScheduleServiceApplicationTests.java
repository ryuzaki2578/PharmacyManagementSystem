package com.cognizant.medicalrepresentative;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.medicalrepresentativeschedule.MedRepScheduleServiceApplication;


@SpringBootTest(classes=MedRepScheduleServiceApplication.class)
 public class MedRepScheduleServiceApplicationTests {

	
	@Test
	public void main() {
		MedRepScheduleServiceApplication.main(new String[] {});
	}

}
