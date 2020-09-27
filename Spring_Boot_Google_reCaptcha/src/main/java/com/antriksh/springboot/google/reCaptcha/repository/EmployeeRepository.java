package com.antriksh.springboot.google.reCaptcha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.antriksh.springboot.google.reCaptcha.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
