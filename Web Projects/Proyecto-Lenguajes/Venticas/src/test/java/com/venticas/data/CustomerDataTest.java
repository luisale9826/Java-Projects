package com.venticas.data;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.venticas.domain.Address;
import com.venticas.domain.ContactInformation;
import com.venticas.domain.Customer;
import com.venticas.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerDataTest {

	@Autowired
	CustomerData customerData;
	@Autowired
	UserData userData;
	
	@Test
	public void findCustomerByID() {
		User user = userData.findUserByID(6);
		Customer customer = customerData.findCustomerByID(user);
		assertNotNull(customer);
	}
	
	@Test
	public void addCustomerDetailsAddress() {
		User user = new User();
		user.setId(10);
		Customer customer = customerData.findCustomerByID(user);
		Address address = new Address();
		address.setAddressLine("cartago");
		address.setCity("cartago");
		address.setState("cartago");
		address.setPostalCode("11111111");
		customer.getAddress().add(address);
		customerData.addCustomerDetailsAddress(customer);
	}
	
	@Test
	public void addCustomerDetailsContactInfo() {
		User user = new User();
		user.setId(10);
		Customer customer = customerData.findCustomerByID(user);
		ContactInformation contactInformation = new ContactInformation();
		contactInformation.setPhone("888888");
		contactInformation.setEmail("albin@gmail.com");
		customer.getContactInformations().add(contactInformation);
		customerData.addCustomerDetailsContactInfo(customer);
	}
	
	
	
	@Test
	public void deleteCustomerByID() {
		User user = userData.findUserByID(10);
		Customer customer = customerData.findCustomerByID(user);
		customerData.deleteCustomerByID(customer.getId());
	}
		
	@Test
	public void updateCustomerContactInfo() {
		ContactInformation c = new ContactInformation();
		c.setEmail("rojap@gmail.com");
		c.setPhone("741852963");
		c.setId(7);
	    customerData.updateCustomerContactInformation(c);
		
	}
	
	
}
