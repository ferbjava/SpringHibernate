package com.tomcat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tomcat.jdbc.entities.Course;
import com.tomcat.jdbc.entities.Instructor;
import com.tomcat.jdbc.entities.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			
			session.beginTransaction();
			
			int insId = 1;
			Instructor tempInstructor = session.get(Instructor.class, insId);
			
			System.out.println("04: Instructor: " + tempInstructor);
			
			System.out.println("04: Courses: " + tempInstructor.getCourses());
			
			session.getTransaction().commit();
			
			session.close();
			System.out.println("\nSession is closed\n");
			System.out.println("04: Finished!");
			
			System.out.println("04: Courses: " + tempInstructor.getCourses());
			
		} finally {
			
			factory.close();
		}

	}

}
