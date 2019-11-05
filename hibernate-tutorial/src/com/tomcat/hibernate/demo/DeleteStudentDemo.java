package com.tomcat.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tomcat.jdbc.entities.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int studentId = 2;
			
			System.out.println("get with specific Id: " + studentId);
			Student myStudent = session.get(Student.class, studentId);
			
			session.delete(myStudent);
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			session.createQuery("delete Student s WHERE s.firstName = 'Anna'").executeUpdate();
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

}
