package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.domin.Customer;

@Service("customerService")
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
 
	@Transactional
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
 
	@Transactional
	public Customer getCustomer(Long id) {
		return customerRepository.findById(id).get();
	}
 
	@Transactional
	public Customer addOrUpdateCustomer(Customer customer) {
		customerRepository.save(customer);
		return customer;
	}
	
	@Transactional
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}
	
	
}
