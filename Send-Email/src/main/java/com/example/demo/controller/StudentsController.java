package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentsDto;
import com.example.demo.response.SuccessResponse;
import com.example.demo.service.StudentsService;

@RestController
public class StudentsController {
	@Autowired
	private StudentsService studentsService;

	@PostMapping("/registerwithCredentilasWithFileAttachedofStudents")
	public ResponseEntity<SuccessResponse> registerwithCredentilasWithFileAttachedofStudents(
			@ModelAttribute StudentsDto studentsDto) throws IOException {
		if (studentsService.registerwithCredentilasWithFileAttachedofStudents(studentsDto) != null) {

			return new ResponseEntity<>(new SuccessResponse(false, "Success", "Saved into DB Successfully"),
					HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "Not Success", null), HttpStatus.BAD_REQUEST);

	}

}
