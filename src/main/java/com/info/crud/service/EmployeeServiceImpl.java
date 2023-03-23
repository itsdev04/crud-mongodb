package com.info.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.crud.entity.Employee;
import com.info.crud.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	public Employee addEmployee(Employee emp) {
		Employee save = empRepo.save(emp);
		return save;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> findAll = empRepo.findAll();
		return findAll;
	}

	@Override
	public Employee getSingleEmployee(Integer id) {
		Employee e = null;
		Optional<Employee> findById = empRepo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return e;
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
