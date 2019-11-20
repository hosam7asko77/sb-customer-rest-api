package com.hit.service;

import com.hit.entity.CustomerEntity;
import com.hit.model.Customer;
import com.hit.repository.CustomerRepostiory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

;

@SpringBootTest
public class ServiceTest {

	@Mock
    CustomerRepostiory customerRepos;
	@InjectMocks
    CustomerServiceImpl customerService;
	
	@Test
	public void CreateCustomerTestPositive() {
		
		CustomerEntity entity=new CustomerEntity();
		entity.setId(5);
		when(customerRepos.save(Mockito.any(CustomerEntity.class))).thenReturn(entity);
		Customer customer=new Customer();
		boolean isSaveData=customerService.saveData(customer);
		Assertions.assertTrue(isSaveData);
		
	}
	@Test
	public void CreateCustomerTestNagitive() {
		when(customerRepos.save(Mockito.any(CustomerEntity.class))).thenReturn(null);
		Customer customer=new Customer();
		customer.setId(101);
		boolean isSaveData=customerService.saveData(customer);
		Assertions.assertFalse(isSaveData);
		
	}
	
	@Test
	public void FindOnePositive() {
		CustomerEntity entity=new CustomerEntity();
		entity.setId(100);
		entity.setFristName("ahmed");
		entity.setLastName("mohamed");
		entity.setSalary(1220.6);
		entity.setEmail("hosam7asko88@gmail.com");
		
		Optional<CustomerEntity> optional=Optional.of(entity);
		when(customerRepos.findById(100)).thenReturn(optional);
		Customer customer=customerService.findOne(100);
		Assertions.assertNotNull(customer);		
		
	}
	
	@Test
	public void FindOneNagitive() {
		when(customerRepos.findById(102)).thenReturn(null);
		Customer customer=customerService.findOne(100);
		Assertions.assertNull(customer);		
	} 
	@Test
	public void findByEmailPositive() {
		CustomerEntity entity=new CustomerEntity();
		entity.setId(100);
		entity.setFristName("ahmed");
		entity.setLastName("mohamed");
		entity.setSalary(1220.6);
		entity.setEmail("hosam7asko88@gmail.com");
		
		when(customerRepos.findByEmail("hosam7asko88@gmail.com")).thenReturn(entity);
		Customer customer=customerService.findByEmail("hosam7asko88@gmail.com");
		Assertions.assertNotNull(customer);		
		
	}
	@Test
	public void findByEmailNagitive() {
		when(customerRepos.findByEmail("hosam@gmail.com")).thenReturn(null);
		Customer customer=customerService.findByEmail("hosam@gmail.com");
		Assertions.assertNull(customer);		
	} 
	@Test
	public void findAllEmailPositive() {
		List<String> emails=new ArrayList<String>();
		emails.add("test@gmail.com");
		emails.add("hosam@gmail.com");
		when(customerRepos.FindAllEmail()).thenReturn(emails);
		List<String> actualEmails=customerService.findAllEmail();
		Assertions.assertEquals(emails.size(), actualEmails.size());	
	}
	@Test
	public void findAllData(){
		List<CustomerEntity> entity=new ArrayList<>();
		entity.add(new CustomerEntity(100,"hosam","ahmed",122.5 ,"hosam@gail.com"));
		entity.add(new CustomerEntity(102,"hosamrr","ahmedff",12244.5 ,"hosam33@gail.com"));
		when(customerRepos.findAll()).thenReturn(entity);
		List<CustomerEntity> actualEmails=customerService.findAllData();
		Assertions.assertEquals(entity.size(), actualEmails.size());

	}
}
