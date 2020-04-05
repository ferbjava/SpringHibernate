package com.ferb.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ferb.cruddemo.entity.Employee;

@RepositoryRestResource(path="employees")
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
