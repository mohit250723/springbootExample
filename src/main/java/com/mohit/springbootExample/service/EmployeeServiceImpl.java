package com.mohit.springbootExample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit.springbootExample.controller.custom.exception.EmptyIputException;
import com.mohit.springbootExample.entity.Employee;
import com.mohit.springbootExample.repos.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo employeeRepo; 
	
	@Override
	public Employee addEmployee(Employee emp) {
		if(emp.getName().isEmpty()) {
		  throw new EmptyIputException(601,"Please provide the name of the employee");
		}
		return employeeRepo.save(emp);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee findEmployeeById(Long empId) {
		return employeeRepo.findById(empId).get();
	}

	@Override
	public void deleteEmp(Long id) {
		employeeRepo.deleteById(id);
	}

}
