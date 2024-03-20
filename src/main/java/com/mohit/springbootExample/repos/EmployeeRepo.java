package com.mohit.springbootExample.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohit.springbootExample.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
	
	public List<Employee> findByName(String name);
}
