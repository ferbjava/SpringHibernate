package com.tomcat.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showView() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processView() {
		return "helloworld";
	}

	@RequestMapping("/processFormV2")
	public String letsShout(HttpServletRequest request, Model model) {
		String name = request.getParameter("studentName");
		name = name.toUpperCase();
		
		String message = "Elo! " + name;
		model.addAttribute("message", message);
		
		return "helloworld";
	}
	
}
