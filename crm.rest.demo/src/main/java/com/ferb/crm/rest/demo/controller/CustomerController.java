package com.ferb.crm.rest.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/customer")
	public Customer saveCustomer(@RequestBody Customer customer) {
		customer.setId(0);
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@PutMapping("/customer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@DeleteMapping("/customer/{id}")
	public String deleteCustomer(@PathVariable int id) {
		
		Customer tempCustomer = customerService.getCustomer(id);
		
		if(tempCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + id);
		}
		
		customerService.deleteCustomer(id);
		return new String("Customer with id: " + id + " succesfully deleted");
	}
	
}
