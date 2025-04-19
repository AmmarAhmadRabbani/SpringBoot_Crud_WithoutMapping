package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmailDto;
import com.example.demo.dto.EmailMultipleDto;
import com.example.demo.response.SuccessResponse;
import com.example.demo.service.EmailService;

@RestController
public class EmailController {
	@Autowired
	private EmailService emailService;

	@PostMapping("/sendEmail")
	public ResponseEntity<SuccessResponse> sendEmailSingleUser(@RequestBody EmailDto emailDto) {
		EmailDto sendEmailSingleUser = emailService.sendEmailSingleUser(emailDto);
		if (sendEmailSingleUser != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "Sent", sendEmailSingleUser), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "Not Send", null), HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/sendMultipleEmail")
	public ResponseEntity<SuccessResponse> sendEmailMultipleUsers(@RequestBody EmailMultipleDto emailMultipleDto) {
		EmailMultipleDto sendEmailMultipleUsers = emailService.sendEmailMultipleUsers(emailMultipleDto);
		if (sendEmailMultipleUsers != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "Successfully", sendEmailMultipleUsers),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "Not Successfully", null), HttpStatus.BAD_REQUEST);
	}

}
