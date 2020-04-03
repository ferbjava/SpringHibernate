package com.ferb.springboot.demoapp.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@Value("${coach.name}")
	private String coachName;

	@GetMapping("/")
	public String helloWorld() {
		return "Hello my friend! Today is: " + LocalDateTime.now() + ", coach name: " + coachName;
	}
}
