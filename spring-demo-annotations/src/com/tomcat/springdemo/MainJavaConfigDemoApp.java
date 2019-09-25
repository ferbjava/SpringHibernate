package com.tomcat.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJavaConfigDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		System.out.println("TennisCoach: " + theCoach.getDailyWorkout());
				
		System.out.println("TennisCoach fortuneService: " + theCoach.getDailyFortune());
		
		Coach swimCoach = context.getBean("swimCoach", Coach.class);
		
		System.out.println("SwimCoach: " + swimCoach.getDailyWorkout());
				
		System.out.println("SwimCoach fortuneService: " + swimCoach.getDailyFortune());
		
		context.close();
	}

}
