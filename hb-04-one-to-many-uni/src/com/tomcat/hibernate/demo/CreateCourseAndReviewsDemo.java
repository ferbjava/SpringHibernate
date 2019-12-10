package com.tomcat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tomcat.jdbc.entities.Course;
import com.tomcat.jdbc.entities.Instructor;
import com.tomcat.jdbc.entities.InstructorDetail;
import com.tomcat.jdbc.entities.Review;

public class CreateCourseAndReviewsDemo {

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
			
			Course tempCourse = new Course("Some course 01");
			tempCourse.addReview(new Review("Great job 01!"));
			tempCourse.addReview(new Review("Great job 02!"));
			tempCourse.addReview(new Review("Great job 03!"));
			
			session.save(tempCourse);

			session.getTransaction().commit();
			System.out.println("Finished!");
			
		} finally {
			session.close();
			
			factory.close();
		}

	}

}
