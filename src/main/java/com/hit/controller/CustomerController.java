package com.hit.controller;

import com.hit.entity.CustomerEntity;
import com.hit.exceptin.CustomerNotFoundException;
import com.hit.model.Customer;
import com.hit.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customers")
	public List<CustomerEntity> retrieveAllCustomers(){
		return customerService.findAllData();
	}
	@PostMapping("/customers")
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
		boolean isSaved = customerService.saveData(customer);
		
		if(isSaved) {
			String msg = "Customer added successfully";
		return new ResponseEntity<String>(msg, HttpStatus.CREATED) ;
		}
		String msg = "failed to Add,Duplicated Customer ";
		return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST) ;
	}
	@GetMapping(value="/customers/{id}")
	public Customer findOneCustomer(@PathVariable int id) {
		Customer customer=customerService.findOne(id);
		if(customer == null) {
			throw new CustomerNotFoundException("Id not found -: "+id);
		}
	 return customer;
	
	}
	@GetMapping(value="/customer-all-emails")
	public List<String> findAllCustomerEmail(){
		List<String> customer=customerService.findAllEmail();
		return customer;
	}
	
	
	@GetMapping(value="/customer-by-email")
	public Customer findCustimerByEmail(@RequestParam(name="email", required = true) String email) {
		Customer customer=customerService.findByEmail(email);
		if(customer==null) {
			throw new CustomerNotFoundException("email not found-: "+email);
		}
		return customer;
	}
	
	
}
