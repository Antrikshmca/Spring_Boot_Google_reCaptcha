package com.antriksh.springboot.google.reCaptcha.service;

import java.util.List;

import com.antriksh.springboot.google.reCaptcha.model.Employee;

public interface IEmployeeService {

	 Integer createEmployee(Employee e);
	 List<Employee> getAllEmployee();
	
}
