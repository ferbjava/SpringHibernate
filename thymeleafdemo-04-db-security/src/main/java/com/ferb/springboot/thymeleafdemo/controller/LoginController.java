package com.ferb.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
	}
}