package com.company.pressarticle.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionControllerHandler {

	@ExceptionHandler(DuplicateEntryException.class)
	public ResponseEntity<ExceptionDetails> handleDuplicateException(DuplicateEntryException e ,
			WebRequest r){
		
		ExceptionDetails details = new ExceptionDetails("duplicate title and author",
				400, LocalDateTime.now());
		return new ResponseEntity<ExceptionDetails>
		(details, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handleNotFoundException(ResourceNotFoundException ex) {
      
		ExceptionDetails details = new ExceptionDetails("can not find author and title",
				404, LocalDateTime.now());
		return new ResponseEntity<ExceptionDetails>
		(details, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ExceptionDetails> handleSqlConstraintException(SQLIntegrityConstraintViolationException ex) {
      
		ExceptionDetails details = new ExceptionDetails("the article already exist",
				400, LocalDateTime.now());
		return new ResponseEntity<ExceptionDetails>
		(details, HttpStatus.BAD_REQUEST);
    }
	
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object>  onConstraintValidationException(ConstraintViolationException e) {
		   ExceptionDetails details = new ExceptionDetails("can not find author and title",
					404, LocalDateTime.now());
		   Map<String, String> errorMessages = new HashMap<>();
		    for (ConstraintViolation violation: e.getConstraintViolations()) {
	            errorMessages.put(violation.getPropertyPath().toString(), violation.getMessage());
	        
	        }
	        return new ResponseEntity<>(errorMessages,  HttpStatus.BAD_REQUEST);
	    }
	
}
