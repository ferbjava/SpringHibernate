package com.tomcat.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	private String emailAddress;
	private String team;
	
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside FortuneService setter");
		this.fortuneService = fortuneService;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside Email setter");
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside Team setter");
		this.team = team;
	}

	public String getTeam() {
		return team;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
