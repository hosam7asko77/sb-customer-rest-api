package com.hit.controller;

import com.hit.entity.CustomerEntity;
import com.hit.exceptin.CustomerNotFoundException;
import com.hit.model.Customer;
import com.hit.service.CustomerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@ApiResponses({@ApiResponse(code = 200, message ="success"),
			@ApiResponse(code = 400 , message = "Bad Request"),
			@ApiResponse(code = 500 , message = "Servaer problem")})
	@ApiOperation(value="This Operation is use to get all customer details")
	@GetMapping(value="/getAll", produces = { "application/json", "application/xml" })
	public List<CustomerEntity> retrieveAllCustomers(){
		return customerService.findAllData();
	}
	
	@ApiResponses({@ApiResponse(code = 200, message ="success"),
		@ApiResponse(code = 201, message ="Created"),
		@ApiResponse(code = 400 , message = "Bad Request"),
		@ApiResponse(code = 500 , message = "server problem")})
	@ApiOperation(value="This Operation is use to save customer details")
	@PostMapping(value="/add", consumes = { "application/json", "application/xml" })
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
		boolean isSaved = customerService.saveData(customer);
		
		if(isSaved) {
			String msg = "Customer added successfully";
		return new ResponseEntity<String>(msg, HttpStatus.CREATED) ;
		}
		String msg = "failed to Add,Duplicated Customer ";
		return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST) ;
	}
	
	@ApiResponses({@ApiResponse(code = 200, message ="success"),
		@ApiResponse(code = 400 , message = "Bad Request"),
		@ApiResponse(code = 404 , message = "Not Found"),
		@ApiResponse(code = 500 , message = "server problem")})
	@ApiOperation(value="This Operation is use to get customer details based on id")
	@GetMapping(value="/get-by-id/{id}", produces = { "application/xml", "application/json" })
	public Customer findOneCustomer(@ApiParam(required = true, example = "123", value="This is represents Customer id") @PathVariable Integer id) {
		Customer customer=customerService.findOne(id);
		if(customer == null) {
			throw new CustomerNotFoundException("Id not found -: "+id);
		}
	 return customer;
	
	}
	@ApiResponses({@ApiResponse(code = 200, message ="success"),
		@ApiResponse(code = 400 , message = "Bad Request"),
		@ApiResponse(code = 500 , message = "problem on server")})
	@ApiOperation(value="his Operation is use to get customers emails")
	@GetMapping(value="/get-all-emails", produces = { "application/xml", "application/json" })
	public List<String> findAllCustomerEmail(){
		List<String> customer=customerService.findAllEmail();
		return customer;
	}
	
	@ApiResponses({@ApiResponse(code = 200, message ="success"),
		@ApiResponse(code = 400 , message = "Bad Request"),
		@ApiResponse(code = 404 , message = "Not Found"),
		@ApiResponse(code = 500 , message = "server problem")})
	@ApiOperation(value="This Operation is use to get customer details based on email")
	@GetMapping(value="/get-by-email", produces = { "application/xml", "application/json" })
	public Customer findCustimerByEmail(@ApiParam(required = true, example = "exampl@gamil.com",value="This is represents Customer email")@RequestParam(name="email", required = true) String email) {
		Customer customer=customerService.findByEmail(email);
		if(customer==null) {
			throw new CustomerNotFoundException("email not found-: "+email);
		}
		return customer;
	}
	
	
}
