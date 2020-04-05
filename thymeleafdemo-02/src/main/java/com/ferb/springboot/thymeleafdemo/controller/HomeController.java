package com.ferb.springboot.thymeleafdemo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/hello")
	public String helloWorld(Model model) {
		model.addAttribute("theDate", new Date());
		return "helloworld";
	}
}
