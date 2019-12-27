package com.ferb.testdb.dao;

import java.util.List;

import com.ferb.testdb.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

}
