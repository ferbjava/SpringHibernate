package com.ferb.crm.rest.demo.dao;

import java.util.List;

import com.ferb.crm.rest.demo.entity.Customer;

public interface CustomerDao {
	
	public List<Customer> getCustomers();
	public void saveCustomer (Customer customer);
	public Customer getCustomer(int id);
	public void deleteCustomer(int id);
	
}
