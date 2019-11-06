package com.tomcat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tomcat.jdbc.entities.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			System.out.println("Create 3 Students object");
			Student student01 = new Student("Michal", "Kotecki", "mk@gmail.com");
			Student student02 = new Student("Pawel", "Kotecki", "pk@gmail.com");
			Student student03 = new Student("Piotr", "Kotecki", "pk@gmail.com");

			session.beginTransaction();

			session.save(student01);
			session.save(student02);
			session.save(student03);

			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}
}
