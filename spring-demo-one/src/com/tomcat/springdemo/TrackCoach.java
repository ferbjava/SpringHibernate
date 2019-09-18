package com.tomcat.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TrackCoach() {
	}
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just do it: " + fortuneService.getFortune();
	}
	
	public void doMyStartup() {
		System.out.println("TrackCoach: inside init method");
	}
	
	public void doMyDestroy() {
		System.out.println("TrackCoach: inside destroy method");
	}

}
