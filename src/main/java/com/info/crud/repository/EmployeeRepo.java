package com.info.crud.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.info.crud.entity.Employee;

public interface EmployeeRepo extends MongoRepository<Employee, Serializable>{

}
