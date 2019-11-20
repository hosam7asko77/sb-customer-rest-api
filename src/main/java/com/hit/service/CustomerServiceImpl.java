package com.hit.service;

import com.hit.entity.CustomerEntity;
import com.hit.model.Customer;
import com.hit.repository.CustomerRepostiory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
    CustomerRepostiory customerRepostiory;
	
	public boolean saveData(Customer customer) {
		
		CustomerEntity entity=new CustomerEntity();
		BeanUtils.copyProperties(customer, entity);
		return customerRepostiory.save(entity)!=null;
	}
	
	public List<CustomerEntity> findAllData(){
		List<CustomerEntity> customer=customerRepostiory.findAll();
		return customer;
		
	}
	
	public Customer findOne(Integer id)
	{
			Optional<CustomerEntity> optional=customerRepostiory.findById(id);
			if(optional.isPresent()) {
				CustomerEntity customerEntity=optional.get();
				Customer customer = new Customer();
				BeanUtils.copyProperties(customerEntity, customer);
			return customer;
			}
			
		return null;
		
	}
	
	public Customer findByEmail(String email)
	{
			CustomerEntity entity=customerRepostiory.findByEmail(email);
			if(entity!=null) {
				Customer customer = new Customer();
				BeanUtils.copyProperties(entity, customer);
			return customer;
			}
			
		return null;
		
	}
	
	public List<String> findAllEmail() {
		
		List<String> customer=customerRepostiory.FindAllEmail();
		return customer;
	}
}
