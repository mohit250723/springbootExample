package com.mohit.springbootExample.custom.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EmployeeExistsByName.class})
public @interface ValidEmployee {
	//error message
	public String message() default "Employee Name is not valid";
	
	//represents group of constraints
	public Class<?>[] groups() default {}; 
	//represents additional info regarding payload
	public Class<? extends Payload>[] payload() default {};

}
