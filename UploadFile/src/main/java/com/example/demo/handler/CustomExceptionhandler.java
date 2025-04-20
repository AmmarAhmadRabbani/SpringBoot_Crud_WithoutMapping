package com.example.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.response.SuccessResponse;

@RestControllerAdvice
public class CustomExceptionhandler {
	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<SuccessResponse> productNotFoundException(Exception exception) {
		return new ResponseEntity<>(new SuccessResponse(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);

	}

}
