package com.mohit.springbootExample.entity;
import com.mohit.springbootExample.custom.annotations.ValidEmployee;
import com.mohit.springbootExample.custom.marker.validators.ValidEmployeeByNameGroup;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ValidEmployee(message = "Please check employee name,Does not exist in DB",groups = {ValidEmployeeByNameGroup.class})
	private String name;
	@NotNull(message = "Salary can not be null")
	private Double salary;
	
	@NotBlank(message="Please Provide empTYpe.It will be either Contractual or Permanent")
	private String empType;
	
	public Employee() {
		super();
	}
	

	public Employee(Long id, String name, @NotNull(message = "Salary can not be null") Double salary, String empType) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.empType = empType;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		this.empType = empType;
	}

}
