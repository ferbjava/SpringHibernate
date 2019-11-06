package com.tomcat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tomcat.jdbc.entities.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Create new Student object");
			Student tempStudent = new Student("Anna", "Kotecka", "ak@gmail.com");
			
			session.beginTransaction();
			
			session.save(tempStudent);
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			
			System.out.println("saved student id: " + tempStudent.getId());
			
			session.beginTransaction();
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			session.getTransaction().commit();
			System.out.println("Retrieved student: " + myStudent.toString());
		} finally {
			factory.close();
		}

	}

}
