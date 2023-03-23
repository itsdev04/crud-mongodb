package com.info.crud.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.info.crud.entity.Employee;
import com.info.crud.exceptions.ResourceNotFoundException;
import com.info.crud.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	public Employee addEmployee(Employee emp) {
		logger.debug("Inside addEmployee() method");
		Employee save = empRepo.save(emp);

		logger.debug("addEmployee() method returned a new Employee Object");
		return save;
	}

	@Override
	public List<Employee> getEmployees() {
		logger.debug("Inside getEmployees() method ");
		List<Employee> findAll = empRepo.findAll();
		logger.debug("Employee list is returned");
		return findAll;
	}

	@Override
	public Employee getSingleEmployee(Integer id) {
		
		logger.debug("Inside getSingleEmployee() method");
		Employee e = null;
		
		Employee findById = empRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id, "Employee"));
	//	Optional<Employee> findById = empRepo.findById(id).orElseThrow(() -> new);
	//	if(findById.isPresent()) {
	//		return findById.get();
	//	}
	//	logger.debug("A single employee is returned");
		return findById;
	}

	@Override
	public Employee updateEmployee(Employee e) {
		if(empRepo.existsById(e.getEid())) {
			empRepo.save(e);
		}
		return e;
	}

	@Override
	public String deleteEmployee(Integer id) {
		empRepo.deleteById(id);
		return "Entity deleted..!!";
	}

	
}
