package com.ferb.rest.demo01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferb.rest.demo01.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	@GetMapping("/students")
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Jan", "Kowalski"));
		students.add(new Student("Adam", "Nowak"));
		students.add(new Student("Piotr", "Wiśniewskie"));
		
		return students;
	}
}
