package com.ferb.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferb.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	
	public List<Employee> findAllByOrderByLastNameAsc();
}
