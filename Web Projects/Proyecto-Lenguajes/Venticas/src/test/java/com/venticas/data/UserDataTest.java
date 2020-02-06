package com.venticas.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.venticas.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDataTest {

	@Autowired
	UserData userData;
	
	@Test
	public void deactivateManager() {
		User user = userData.findUserByID(7);
		userData.deactivateManager(user);
	}
}
