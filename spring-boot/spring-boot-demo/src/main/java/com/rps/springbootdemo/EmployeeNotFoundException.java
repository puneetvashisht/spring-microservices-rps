package com.rps.springbootdemo;

import org.springframework.http.HttpStatus; // Import the HttpStatus class
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{
        
        public EmployeeNotFoundException(String message) {
            super(message);
        }
}
