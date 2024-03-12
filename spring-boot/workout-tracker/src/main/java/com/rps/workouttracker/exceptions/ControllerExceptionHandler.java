package com.rps.workouttracker.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleResourceNotFoundException(ResourceNotFoundException e){
        // create errorMessage object
    	
    	System.out.println("Creating error message in custom handler ....... ");
        ErrorMessage errorMessage = new ErrorMessage( HttpStatus.NOT_FOUND.value(),  e.getMessage(), "dkd", new Date()) ;
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
