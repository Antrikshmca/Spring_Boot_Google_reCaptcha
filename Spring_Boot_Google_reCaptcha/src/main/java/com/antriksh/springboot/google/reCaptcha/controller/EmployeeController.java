package com.antriksh.springboot.google.reCaptcha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.antriksh.springboot.google.reCaptcha.model.CaptchaResponse;
import com.antriksh.springboot.google.reCaptcha.model.Employee;
import com.antriksh.springboot.google.reCaptcha.service.IEmployeeService;
import com.antriksh.springboot.google.reCaptcha.validator.CaptchaValidator;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private IEmployeeService service;
	@Autowired
	private CaptchaValidator validator;

	// show register page
	@GetMapping("/register")
	public String showReg(Model model) {
		model.addAttribute("employee", new Employee());
		return "EmpReg";
	}

	// save data on submit
	@PostMapping("/save")
	public String save(@ModelAttribute Employee employee, @RequestParam("g-recaptcha-response") String captcha,
			Model model) {

		
		if (validator.isValid(captcha)) {
			Integer id = service.createEmployee(employee);
			model.addAttribute("message", "Employee '" + id + "' Saved");
			model.addAttribute("employee", new Employee());
		} else {
			model.addAttribute("message", "Please validate captcha ");
		}
		return "EmpReg";
	}

	// display all record
	@GetMapping("/all")
	public String fetchAll(Model model) {
		List<Employee> list = service.getAllEmployee();
		model.addAttribute("list", list);
		return "EmpData";
	}

}
