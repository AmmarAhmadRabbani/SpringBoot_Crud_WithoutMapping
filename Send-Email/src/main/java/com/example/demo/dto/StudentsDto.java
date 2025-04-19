package com.example.demo.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentsDto {
	private String customerName;
	private String emailId;
	private String password;
	private long contactNumber;
	private MultipartFile attachment;

}
