package com.ferb.crm.rest.demo.service;

import java.util.List;

import com.ferb.crm.rest.demo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> gestCustomers();
	public void saveCustomer(Customer customer);
	public Customer getCustomer(int id);
	public void deleteCustomer(int id);

}
