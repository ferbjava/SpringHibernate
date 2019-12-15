package com.tomcat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tomcat.jdbc.entities.Course;
import com.tomcat.jdbc.entities.Instructor;
import com.tomcat.jdbc.entities.InstructorDetail;
import com.tomcat.jdbc.entities.Review;
import com.tomcat.jdbc.entities.Student;

public class CreateCourseAndReviewsDemo {

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
			
			Course tempCourse = new Course("Some course 01");
			
			session.save(tempCourse);
			System.out.println("Saved the course: " + tempCourse.toString());
			
			Student tempStudent01 = new Student("Jan", "Kowalski", "jan.kowalski@gmail.com");
			Student tempStudent02 = new Student("Adam", "Nowak", "a.nowak@gmail.com");
			
			tempCourse.addStudent(tempStudent01);
			tempCourse.addStudent(tempStudent02);
			
			System.out.println("Saving students...");
			session.save(tempStudent01);
			session.save(tempStudent02);
			System.out.println("Students saved: " + tempCourse.getStudents());
			
			
			session.getTransaction().commit();
			System.out.println("Finished!");
			
		} finally {
			session.close();
			
			factory.close();
		}

	}

}
