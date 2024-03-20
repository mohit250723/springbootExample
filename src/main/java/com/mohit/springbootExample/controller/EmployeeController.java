package com.mohit.springbootExample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.springbootExample.custom.annotations.AnyEmployeeFound;
import com.mohit.springbootExample.custom.annotations.ValidEmployee;
import com.mohit.springbootExample.custom.marker.validators.ValidEmployeeByNameGroup;
import com.mohit.springbootExample.entity.Employee;
import com.mohit.springbootExample.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/empoyee")
public class EmployeeController  {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/home")
	public String welcomePage() {
		
		return "Welcome Mohit Saini..This is default Page";
	}
	
	@PostMapping("/save")
	public ResponseEntity<Employee> addNewEmployee(@Valid @RequestBody Employee emp) {
		  Employee employee=employeeService.addEmployee(emp);
		  return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
		}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmplyees(){
		List<Employee> empList=employeeService.findAllEmployees();
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
		}
	
	@GetMapping("find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee emp= employeeService.findEmployeeById(id);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	

	@GetMapping("find/params")
	public ResponseEntity<Employee> getEmployeeByRequestParams(@RequestParam Long id) {
		Employee emp= employeeService.findEmployeeById(id);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@Validated(ValidEmployeeByNameGroup.class) @RequestBody Employee emp) {
		  Employee employee=employeeService.addEmployee(emp);
		  return new ResponseEntity<Employee>(employee,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteEmp(@PathVariable Long id) {
		    employeeService.deleteEmp(id);
	}

}
