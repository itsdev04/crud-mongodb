package com.info.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.info.crud.entity.Employee;
import com.info.crud.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/create")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee e){
		Employee addEmployee = empService.addEmployee(e);
		return new ResponseEntity<Employee>(addEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> employees = empService.getEmployees();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer id){
		Employee singleEmployee = empService.getSingleEmployee(id);
		return new ResponseEntity<Employee>(singleEmployee, HttpStatus.OK);
	}
	/*
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(Employee e, Integer id){
		Employee updateEmployee = empService.updateEmployee(e, id);
		return new ResponseEntity<Employee>(updateEmployee, HttpStatus.OK);
	}
	*/
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){
		String deleteEmployee = empService.deleteEmployee(id);
		return new ResponseEntity<String>(deleteEmployee, HttpStatus.OK);
	}
}
