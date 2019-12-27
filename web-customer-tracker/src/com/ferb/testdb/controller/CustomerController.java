package com.ferb.testdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ferb.testdb.dao.CustomerDAO;
import com.ferb.testdb.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDAO customerDao;
	
	@RequestMapping("/list")
	public String listCustomer(Model model) {
		
		List<Customer> customers = customerDao.getCustomers();
		
		model.addAttribute("customers", customers);
		
		return "list-customer";
	}

}
