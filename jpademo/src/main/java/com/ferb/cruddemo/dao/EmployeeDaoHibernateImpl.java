package com.ferb.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ferb.cruddemo.entity.Employee;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {

	@Autowired
	private EntityManager em;
	
	@Override
	public List<Employee> getEmployees() {
		Session session = em.unwrap(Session.class);
		
		Query<Employee> query = session.createQuery("FROM Employee", Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee getById(int id) {
		Session session = em.unwrap(Session.class);
		
		return session.get(Employee.class, id);
	}

	@Override
	public void save(Employee employee) {
		Session session = em.unwrap(Session.class);
		
		session.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int id) {
		Session session = em.unwrap(Session.class);
		Query query = session.createQuery("DELETE FROM Employee WHERE id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
