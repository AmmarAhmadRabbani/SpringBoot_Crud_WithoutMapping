package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {
	private String employeeName;
	private String employeeDepartment;

	private String imageName;
	private String imageType;
//	@Lob
	private byte[] imageData;

}
