package com.example.demo.domin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private Long id;
 
	private String customerName;  
	private String email;
	private String status;
 
	public Customer() {
		super();
	}
	public Customer(Long id, String customerName,String email, String status) {
		super();
		this.id = id;
		this.customerName=customerName;
		this.email=email;
		this.status = status;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
