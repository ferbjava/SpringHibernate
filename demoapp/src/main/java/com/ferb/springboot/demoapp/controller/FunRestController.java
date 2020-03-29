package com.ferb.springboot.demoapp.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@GetMapping("/")
	public String helloWorld() {
		return "Hello my friend! Today is: " + LocalDateTime.now();
	}
}
