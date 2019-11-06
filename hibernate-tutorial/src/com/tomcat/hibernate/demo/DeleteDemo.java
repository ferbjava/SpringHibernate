package com.tomcat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tomcat.jdbc.entities.Instructor;
import com.tomcat.jdbc.entities.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			
			int primaryKey = 1;
			
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, primaryKey);
			
			if(instructor != null) {
				session.delete(instructor);
			}

			session.getTransaction().commit();
			System.out.println("Finished!");
		} finally {
			factory.close();
		}

	}

}
