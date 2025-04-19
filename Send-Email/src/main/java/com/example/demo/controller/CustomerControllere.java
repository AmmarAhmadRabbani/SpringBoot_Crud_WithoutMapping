package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomersDto;
import com.example.demo.dto.CustomersFileDto;
import com.example.demo.response.SuccessResponse;
import com.example.demo.service.CustomersService;

@RestController
public class CustomerControllere {
	@Autowired
	private CustomersService customersService;

	@PostMapping("/registerCustomers")
	public ResponseEntity<SuccessResponse> registerCustomers(@RequestBody CustomersDto customersDto) {
		CustomersDto registerCustomers = customersService.registerCustomers(customersDto);
		if (registerCustomers != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "Registered", registerCustomers), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "Not Registered", null), HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/registerWithCredentials")
	public ResponseEntity<SuccessResponse> registerWithCredentials(@RequestBody CustomersDto customersDto) {
		CustomersDto registerWithCredentials = customersService.registerWithCredentials(customersDto);
		if (registerWithCredentials != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "Registered Success", registerWithCredentials),
					HttpStatus.OK);

		}
		return new ResponseEntity<>(new SuccessResponse(true, "Registered not Success", null), HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/registerwithCredentilasFileAttached")
	public ResponseEntity<SuccessResponse> registerwithCredentilasWithFileAttached(
			@ModelAttribute CustomersFileDto customersFileDto) throws IOException {
		if (customersService.registerwithCredentilasWithFileAttached(customersFileDto) != null) {

			return new ResponseEntity<>(new SuccessResponse(false, "Success", "SuccessFully Done"), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "Not Success", null), HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/registerBcrypt ")
	public ResponseEntity<SuccessResponse> registerWithPasswordBCryptCredentials(
			@RequestBody CustomersDto customersDto) {
		CustomersDto registerWithPasswordBCryptCredentials = customersService
				.registerWithPasswordBCryptCredentials(customersDto);
		if (registerWithPasswordBCryptCredentials != null) {
			return new ResponseEntity<>(
					new SuccessResponse(false, "Registration Sucessfully", registerWithPasswordBCryptCredentials),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "Failed", null), HttpStatus.BAD_REQUEST);
	}

}
