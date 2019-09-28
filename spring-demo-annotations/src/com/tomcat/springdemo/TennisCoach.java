package com.tomcat.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("dynamicFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println(">> Inside TennisCoach constructor");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	@PostConstruct
	private void initMethod() {
		System.out.println("\nIn PostConstruct stage");
	}
	
	@PreDestroy
	private void endingMethod() {
		System.out.println("\nIn PreDestroy stage");
	}
	
//	@Autowired
//	public void doSomething(FortuneService fortuneService) {
//		System.out.println(">> setter for FortuneService");
//		this.fortuneService = fortuneService;
//	}

}