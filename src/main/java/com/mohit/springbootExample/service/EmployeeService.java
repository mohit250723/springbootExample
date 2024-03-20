package com.mohit.springbootExample.service;

import java.util.List;

import com.mohit.springbootExample.entity.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee emp);

	public List<Employee> findAllEmployees();

	public Employee findEmployeeById(Long empId);

	public void deleteEmp(Long id);

}
