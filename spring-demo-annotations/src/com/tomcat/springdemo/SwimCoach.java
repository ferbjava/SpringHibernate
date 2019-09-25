package com.tomcat.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {
	
	@Value("${foo.mail}")
	private String email;

	@Value("${foo.team}")
	private String team;
	
	@Autowired
	@Qualifier(value="happyFortuneService")
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "Some Workout +  team: " + team;
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
