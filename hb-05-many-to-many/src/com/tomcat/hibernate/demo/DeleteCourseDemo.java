package com.tomcat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tomcat.jdbc.entities.Course;
import com.tomcat.jdbc.entities.Instructor;
import com.tomcat.jdbc.entities.InstructorDetail;
import com.tomcat.jdbc.entities.Review;
import com.tomcat.jdbc.entities.Student;

public class DeleteCourseDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			
			session.beginTransaction();
			
			int courseId = 2;
			
			Course tempCourse = session.get(Course.class, courseId);
			
			session.delete(tempCourse);
			
			session.getTransaction().commit();
			System.out.println("Finished!");
			
		} finally {
			session.close();
			
			factory.close();
		}

	}

}
