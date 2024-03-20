package com.mohit.springbootExample.global.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import com.mohit.springbootExample.controller.custom.exception.EmptyIputException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(EmptyIputException.class)
	public ResponseEntity<Object> handleEmptyIputException(EmptyIputException ex){
		return new ResponseEntity<Object>(ex.getErrorMessage(),HttpStatusCode.valueOf(ex.getErrorCode()));
		
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		return new ResponseEntity<Object>("Invalid Request Body,Please check your request and try again !",HttpStatus.BAD_GATEWAY);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		return new ResponseEntity<Object>("Invalid Request Type,Please check your request type and try again !",HttpStatus.BAD_GATEWAY);
	
	}
	@Override
	protected ResponseEntity<Object> handleNoResourceFoundException(NoResourceFoundException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		return new ResponseEntity<Object>("Invalid Request,Please check your request type and try again !",HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoElementExc(){
		return new ResponseEntity<String>("Element Not Found in Database..!",HttpStatus.NOT_FOUND); 
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		 List<String> errors = new ArrayList<String>();
		    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
		        errors.add(error.getField() + ": " + error.getDefaultMessage());
		    }
		    for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
		        errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
		    }
		   
		   return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
	}
	

}
