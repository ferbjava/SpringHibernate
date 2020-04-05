package com.ferb.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferb.cruddemo.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
