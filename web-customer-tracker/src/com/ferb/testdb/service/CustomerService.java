package com.ferb.testdb.service;

import java.util.List;

import com.ferb.testdb.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}