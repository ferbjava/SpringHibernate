package com.tomcat.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSetterDemoApp {

	public static void main(String[] args) {
		// load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// call methods
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		// call getters
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		
		// close context
		context.close();
	}

}
