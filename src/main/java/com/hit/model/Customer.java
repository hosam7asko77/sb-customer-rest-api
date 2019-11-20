package com.hit.model;

public class Customer {
	private Integer id ;
	private String fristName;
	private String lastName;
	private double salary;
	private String email;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(Integer id, String fristName, String lastName, double salary,String email) {
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
		return "Customer [id=" + id + ", fristName=" + fristName + ", lastName=" + lastName + ", salary=" + salary
				+ "]";
	}

	

}
