package com.tomcat.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnnotationDemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach footballCoach = context.getBean("footballCoach", Coach.class);
		
		System.out.println("TennisCoach: " + theCoach.getDailyWorkout());
		System.out.println("FootballCoach: " + footballCoach.getDailyWorkout());
				
		context.close();
	}

}
