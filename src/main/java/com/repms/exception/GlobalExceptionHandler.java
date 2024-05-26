package com.repms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



public class GlobalExceptionHandler {
	@ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleSupplierException(IdNotFoundException ex, WebRequest request)
    {
        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
    }
    
}
