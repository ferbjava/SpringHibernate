package com.tomcat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tomcat.jdbc.entities.Course;
import com.tomcat.jdbc.entities.Instructor;
import com.tomcat.jdbc.entities.InstructorDetail;

public class FetchJoinDemo {

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
			
			// solution with HQL
			Query<Instructor> query = session.createQuery("SELECT i FROM Instructor i "
					+ "JOIN FETCH i.courses "
					+ "WHERE i.id=:theInstructorId ",
					Instructor.class);
			query.setParameter("theInstructorId", insId);
			
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("04: Instructor: " + tempInstructor);
			
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
