package com.mohit.springbootExample.custom.annotations;

import org.springframework.beans.factory.annotation.Autowired;

import com.mohit.springbootExample.repos.EmployeeRepo;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeeExistsByName implements ConstraintValidator<ValidEmployee,String>{

	@Autowired
	EmployeeRepo repo;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(repo.findByName(value).size() == 0) {
			return false;
		}
		return true;
	}
	
	
}
