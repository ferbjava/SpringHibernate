package com.ferb.spring.aop;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ferb.spring.aop.service.TrafficFortuneService;

public class AroundMainApp {
	
	private static Logger LOGGER = Logger.getLogger(AroundMainApp.class.getName());

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		LOGGER.info("\nMainProgram");
		
		LOGGER.info("Calling service method with true parameter");
		boolean tripWire = true;
		String data = fortuneService.getFortune(tripWire);
		
		LOGGER.info("Result of the method is: " + data);
		LOGGER.info("Program finished");
		
		context.close();

	}

}
