package com.tomcat.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showView() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	@RequestMapping("/processFormV2")
	public String processFormV2(HttpServletRequest request, Model model) {
		String name = request.getParameter("studentName");
		name = name.toUpperCase();
		
		String message = "Elo! " + name;
		model.addAttribute("message", message);
		
		return "helloworld";
	}

	@RequestMapping("/processFormV3")
	public String processFormV3(@RequestParam("studentName") String name, Model model) {
		name = name.toUpperCase();
		
		String message = "Heya! " + name;
		model.addAttribute("message", message);
		
		return "helloworld";
	}
	
}
