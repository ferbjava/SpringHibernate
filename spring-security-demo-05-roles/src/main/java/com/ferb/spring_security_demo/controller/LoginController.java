package com.ferb.spring_security_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "fancy-login";
	}

	@GetMapping("/accessDenied")
	public String accessDeniedPage() {
		return "access-denied";
	}
}
