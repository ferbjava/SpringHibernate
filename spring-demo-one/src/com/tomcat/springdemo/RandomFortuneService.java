package com.tomcat.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	
	private String[] fortuneArray = {"sdsd", "adad", "jghj"};

	@Override
	public String getFortune() {
		Random generator = new Random();
		int i = generator.nextInt(3);
		return fortuneArray[i];
	}

}
