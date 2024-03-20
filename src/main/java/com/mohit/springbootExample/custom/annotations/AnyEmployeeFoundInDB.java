package com.mohit.springbootExample.custom.annotations;

import org.springframework.beans.factory.annotation.Autowired;

import com.mohit.springbootExample.repos.EmployeeRepo;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AnyEmployeeFoundInDB implements ConstraintValidator<AnyEmployeeFound,Object>{

	@Autowired
	private EmployeeRepo repo;
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if(repo.findAll().size() == 0)
			 return false;
		return true;
		
	}
}
