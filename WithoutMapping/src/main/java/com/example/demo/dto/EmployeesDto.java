package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesDto {
	private long employeeId;
	private String employeeName;
	private String age;
	private String employeeDepartment;
	private String emailId;
	private String password;
	private long contactNumber;

}
