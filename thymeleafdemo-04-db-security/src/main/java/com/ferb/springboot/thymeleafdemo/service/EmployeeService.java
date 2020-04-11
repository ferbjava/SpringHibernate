package com.ferb.springboot.thymeleafdemo.service;

import java.util.List;

import com.ferb.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();

	public Employee getById(int id);

	public void save(Employee employee);

	public void deleteById(int id);

}
