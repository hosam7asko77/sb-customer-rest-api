package com.hit.repository;

import com.hit.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepostiory extends JpaRepository<CustomerEntity, Integer> {
	@Query(value = "from CustomerEntity where email=:email")
	public CustomerEntity findByEmail(String email);
	@Query(value="select email from CustomerEntity")
	public List<String> FindAllEmail();

}
