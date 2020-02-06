package com.venticas.data;

import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.venticas.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeDataTest {

	@Autowired
	EmployeeData employeeData;
	@Autowired
	UserData userData;
	
	@Test
	public void firstLoginEmployee() {
		User user = userData.findUserByUserName("esteF");
		boolean firstTime = employeeData.firstLoginEmployee(user);
		assertFalse(firstTime);
	}
}
