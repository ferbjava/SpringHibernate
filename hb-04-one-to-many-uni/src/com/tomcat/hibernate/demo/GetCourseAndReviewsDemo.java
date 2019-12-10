package com.tomcat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tomcat.jdbc.entities.Course;
import com.tomcat.jdbc.entities.Instructor;
import com.tomcat.jdbc.entities.InstructorDetail;
import com.tomcat.jdbc.entities.Review;

public class GetCourseAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			
			session.beginTransaction();
			
			int courseId = 1;
			
			Course tempCourse = session.get(Course.class, courseId);

			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			
			session.getTransaction().commit();
			System.out.println("Finished!");
			
		} finally {
			session.close();
			
			factory.close();
		}

	}

}
