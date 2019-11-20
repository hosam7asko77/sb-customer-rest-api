package com.hit.service;

import com.hit.entity.CustomerEntity;
import com.hit.model.Customer;

import java.util.List;

public interface CustomerService {
		public boolean saveData(Customer customer);
		public List<CustomerEntity> findAllData();
		public Customer findOne(Integer id);
		public Customer findByEmail(String email);
		public List<String> findAllEmail();
}
