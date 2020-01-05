package com.ferb.spring.aop.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	public String getFortune() {
		
		// simulate delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Expect heavy traffic";
		
	}
	
	public String getFortune(boolean tripWire) {
		
		if(tripWire) {
			throw new RuntimeException("Major accident!");
		}
		return getFortune();
		
	}

}
