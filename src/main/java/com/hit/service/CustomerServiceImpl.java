package com.hit.service;

import com.hit.entity.CustomerEntity;
import com.hit.model.Customer;
import com.hit.repository.CustomerRepostiory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	public CustomerServiceImpl() {
		logger.info("CustomerServiceImpl :: Instantiated");
	}
	
	Logger logger=LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
    CustomerRepostiory customerRepostiory;
	
	public boolean saveData(Customer customer) {
		logger.debug("saveData() method started");
		CustomerEntity entity=new CustomerEntity();
		BeanUtils.copyProperties(customer, entity);
		logger.debug("saveData() method ended");
		logger.info("data saved Successfully");
		return customerRepostiory.save(entity)!=null;
	}
	
	public List<CustomerEntity> findAllData(){
		List<CustomerEntity> customer=customerRepostiory.findAll();
		return customer;
		
	}
	
	public Customer findOne(Integer id)
	{
			logger.debug("findOne() method started");
			Optional<CustomerEntity> optional=customerRepostiory.findById(id);
			if(optional.isPresent()) {
				CustomerEntity customerEntity=optional.get();
				Customer customer = new Customer();
				BeanUtils.copyProperties(customerEntity, customer);
			return customer;
			}
			logger.debug("findOne() method ended");
			logger.warn("CustomerNotFound with given ID -: "+ id);
		return null;
		
	}
	
	public Customer findByEmail(String email)
	{
			logger.debug("findByEmail() method started");
			CustomerEntity entity=customerRepostiory.findByEmail(email);
			if(entity!=null) {
				Customer customer = new Customer();
				BeanUtils.copyProperties(entity, customer);
			return customer;
			}
			logger.debug("findByEmail() method ended");
			logger.warn("CustomerNotFound By given Email -: "+email);
		return null;
		
	}
	
	public List<String> findAllEmail() {
		logger.debug("findAllEmail() method started");
		List<String> customer=customerRepostiory.FindAllEmail();
		logger.debug("findAllEmail() method ended");
		return customer;
	}
}
