package com.ferb.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ferb.cruddemo.dao.EmployeeDao;
import com.ferb.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	@Transactional
	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}

	@Override
	@Transactional
	public Employee getById(int id) {
		return employeeDao.getById(id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		employeeDao.deleteById(id);
	}

}
