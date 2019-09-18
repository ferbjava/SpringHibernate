package com.tomcat.springdemo;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Run fast!";
	}

}
