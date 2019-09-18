package com.tomcat.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainBeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		boolean results = (theCoach == alphaCoach);
		System.out.println("The same object? " + results);
		System.out.println("Memory location for theCoach: " + theCoach);
		System.out.println("Memory location for alphaCoach: " + alphaCoach);
		
		context.close();
	}

}
