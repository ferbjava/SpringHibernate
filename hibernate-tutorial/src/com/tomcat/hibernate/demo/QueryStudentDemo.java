package com.tomcat.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tomcat.jdbc.entities.Student;

public class QueryStudentDemo {

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
			
			System.out.println("all:");
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			theStudents.forEach(s -> System.out.println(s.toString()));
			
			System.out.println("with last name 'Kotecka'");
			theStudents = session.createQuery("from Student s WHERE s.lastName = 'Kotecka'").getResultList();
			theStudents.forEach(s -> System.out.println(s.toString()));
			
			System.out.println("with last name 'Kotecka' or first name 'Piotr'");
			theStudents = session.createQuery("from Student s WHERE s.lastName = 'Kotecka' OR s.firstName = 'Piotr'").getResultList();
			theStudents.forEach(s -> System.out.println(s.toString()));
			
			System.out.println("with first name starts with 'P'");
			theStudents = session.createQuery("from Student s WHERE s.firstName LIKE 'P%'").getResultList();
			theStudents.forEach(s -> System.out.println(s.toString()));
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

}
