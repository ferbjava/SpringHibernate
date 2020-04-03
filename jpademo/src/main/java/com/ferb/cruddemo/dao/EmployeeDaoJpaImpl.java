package com.ferb.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.ferb.cruddemo.entity.Employee;

public class EmployeeDaoJpaImpl implements EmployeeDao {
	
	@Autowired
	private EntityManager em;

	@Override
	public List<Employee> getEmployees() {
		Query query = em.createQuery("FROM Employee");
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Override
	public Employee getById(int id) {
		return em.find(Employee.class, id);
	}

	@Override
	public void save(Employee employee) {
		em.merge(employee);
	}

	@Override
	public void deleteById(int id) {
		Query query = em.createQuery("DELETE FROM EMployee WHERE id=: id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
