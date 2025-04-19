package com.example.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.exception.EmailIdNotFoundException;
import com.example.demo.response.SuccessResponse;

@RestControllerAdvice
public class CustomExceptionhandler {
	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<SuccessResponse> customerNotFoundException(Exception exception) {
		return new ResponseEntity<>(new SuccessResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = EmailIdNotFoundException.class)
	public ResponseEntity<SuccessResponse> emailIdNotFoundException(Exception exception) {
		return new ResponseEntity<>(new SuccessResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
	}

}
