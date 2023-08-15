package com.myapp.book;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentException {
	@ExceptionHandler(AgeNotEligibleException.class)
	public ResponseEntity<Object> AgeNotFountException(AgeNotEligibleException ae){
		return new ResponseEntity<Object>(ae.getMessage(), HttpStatus.NOT_FOUND);
	}

}
