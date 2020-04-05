package com.ferb.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ferb.springboot.thymeleafdemo.entity.Employee;
import com.ferb.springboot.thymeleafdemo.service.EmployeeService;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/list")
	public String listEmployees(Model model) {
		List<Employee> employees = employeeService.getEmployees();
		model.addAttribute("employees", employees);
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormAdd(Model model) {
		Employee newEmployee = new Employee();
		model.addAttribute("employee", newEmployee);
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		employeeService.save(theEmployee);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormUpdate(@RequestParam("employeeId") int id, Model model) {
		
		Employee employee = employeeService.getById(id);
		model.addAttribute("employee", employee);
		return "employees/employee-form";
	}
	
	@GetMapping("/deleteById")
	public String deleteEmployee(@RequestParam("employeeId")int id, Model model) {
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}
}
