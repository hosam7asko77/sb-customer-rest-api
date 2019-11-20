package com.hit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class CustomerEntity {
	
	
	@Id
	@GeneratedValue
	private Integer id ;
	private String fristName;
	private String lastName;
	private double salary;
	private String email;
	
	
	public CustomerEntity() {
	}


	public CustomerEntity(Integer id, String fristName, String lastName,double salary,String email) {
		super();
		this.id = id;
		this.fristName = fristName;
		this.lastName = lastName;
		this.salary = salary;
		this.email=email;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFristName() {
		return fristName;
	}


	public void setFristName(String fristName) {
		this.fristName = fristName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}

	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "CustomerEntity [Id=" + id + ", fristName=" + fristName + ", lastName=" + lastName + ", salary=" + salary + ", email=" + email + "]";
	}
	
}
