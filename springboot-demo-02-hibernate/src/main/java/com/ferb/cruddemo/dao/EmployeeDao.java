package com.ferb.cruddemo.dao;

import java.util.List;

import com.ferb.cruddemo.entity.Employee;

public interface EmployeeDao {

	public List<Employee> getEmployees();
	public Employee getById(int id);
	public void save(Employee employee);
	public void deleteById(int id);
}
