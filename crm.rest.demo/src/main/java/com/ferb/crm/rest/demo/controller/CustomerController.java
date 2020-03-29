package com.ferb.crm.rest.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferb.crm.rest.demo.entity.Customer;
import com.ferb.crm.rest.demo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customer")
	public List<Customer> getCustomers() {
		return customerService.gestCustomers();
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustomer(@PathVariable("id") int id) {
		
		Customer customer = customerService.getCustomer(id);
		if(customer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + id);
		}
		return customer;
	}
	
}
