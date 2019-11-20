package com.hit.controller;

import com.hit.entity.CustomerEntity;
import com.hit.model.Customer;
import com.hit.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CustomerController.class)
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CustomerService customerService;
	
	@Test
	public void findAllCustomersEmailsTest() throws Exception {
		List<String> emails = new ArrayList<String>();
		emails.add("test@gmail.com");
		emails.add("test2@gmail.com");
		when(customerService.findAllEmail()).thenReturn(emails);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customer-all-emails");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	@Test
	public void findCustoerByEmailTestPositive() throws Exception {
		Customer customer = new Customer();
		customer.setId(100);
		when(customerService.findByEmail("hosam7asko@gmail.com")).thenReturn(customer);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customer-by-email/?email=hosam7asko@gmail.com");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(200, status);	
	}
	
	@Test 
	public void findCustoerByEmailTestNagitive() throws Exception {
		Customer customer = new Customer();
		customer.setId(100);
		when(customerService.findByEmail("hosam7asko66@gmail.com")).thenReturn(customer);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customer-by-email/?email=hosam7asko@gmail.com");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(404, status);	
	}
	@Test
	public void findOneCustomerTestPositive() throws Exception {
		Customer customer = new Customer();
		customer.setId(200);
		customer.setFristName("hosam");
		customer.setLastName("adam");
		customer.setSalary(1299.33);
		customer.setEmail("hosam@gmail.com");
		when(customerService.findOne(200)).thenReturn(customer);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customers/200"); 
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(200, status);	
	}
	@Test
	public void findOneCustomerTestNagitive() throws Exception {
		Customer customer = new Customer();
		customer.setId(200);
		when(customerService.findOne(200)).thenReturn(customer);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customers/300"); 
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(404, status);	
	}
	
	
	@Test
	public void retrieveAllCustomersTest() throws Exception {
		List<CustomerEntity> entity = new ArrayList<>();
		entity.add(new CustomerEntity(100,"hosam","ahmed",122.5 ,"hosam@gail.com"));
		entity.add(new CustomerEntity(102,"hosamrr","ahmedff",12244.5 ,"hosam33@gail.com"));
		when(customerService.findAllData()).thenReturn(entity);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customers"); 
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(200,status);
		
		
	}
}
