package com.tomcat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tomcat.jdbc.entities.Instructor;
import com.tomcat.jdbc.entities.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int id = 4;

			session.beginTransaction();

			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, id);

			System.out.println("Instructor detail: " + tempInstructorDetail);

			System.out.println("Instructor: " + tempInstructorDetail.getInstructor());
			
			System.out.println("deleting details");
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(tempInstructorDetail);

			session.getTransaction().commit();
			System.out.println("Finished!");
		} catch (Exception e) {
			e.printStackTrace();
			session.close();
		} finally {
			factory.close();
		}

	}

}
