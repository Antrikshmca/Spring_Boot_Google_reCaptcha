package com.antriksh.springboot.google.reCaptcha.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.antriksh.springboot.google.reCaptcha.model.Employee;
import com.antriksh.springboot.google.reCaptcha.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeRepository repo;

	@Override
	public Integer createEmployee(Employee e) {
		return repo.save(e).getId();
	}

	@Override
	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}

}
