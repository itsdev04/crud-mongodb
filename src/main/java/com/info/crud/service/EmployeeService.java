package com.info.crud.service;

import java.util.List;

import com.info.crud.entity.Employee;

public interface EmployeeService {
	
	Employee addEmployee(Employee emp);
	List<Employee> getEmployees();
	Employee getSingleEmployee(Integer id);
	Employee updateEmployee(Employee e);
	String deleteEmployee(Integer id);
}
