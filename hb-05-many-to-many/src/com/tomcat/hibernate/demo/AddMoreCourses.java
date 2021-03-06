package com.tomcat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tomcat.jdbc.entities.Course;
import com.tomcat.jdbc.entities.Instructor;
import com.tomcat.jdbc.entities.InstructorDetail;
import com.tomcat.jdbc.entities.Review;
import com.tomcat.jdbc.entities.Student;

public class AddMoreCourses {

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
			
			int studentId = 1;
			
			Student tempStudent = session.get(Student.class, studentId);

			System.out.println("Loaded student: " + tempStudent);
			System.out.println("Courses: " + tempStudent.getCourses());
			
			Course tempCourse01 = new Course("Some other great course");
			Course tempCourse02 = new Course("The best course");
			
			tempCourse01.addStudent(tempStudent);
			tempCourse02.addStudent(tempStudent);
			
			System.out.println("Saving courses...");
			
			session.save(tempCourse01);
			session.save(tempCourse02);
			
			session.getTransaction().commit();
			System.out.println("Finished!");
			
		} finally {
			session.close();
			
			factory.close();
		}

	}

}
