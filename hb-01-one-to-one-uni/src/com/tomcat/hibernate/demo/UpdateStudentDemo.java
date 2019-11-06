package com.tomcat.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tomcat.jdbc.entities.Student;

public class UpdateStudentDemo {

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
			
			int studentId = 1;
			
			System.out.println("get with specific Id: " + studentId);
			Student myStudent = session.get(Student.class, studentId);
			myStudent.setFirstName("Slawek");			
			
			session.getTransaction().commit();
			
			
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set email = 'kotecki@wp.pl'").executeUpdate();
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

}
