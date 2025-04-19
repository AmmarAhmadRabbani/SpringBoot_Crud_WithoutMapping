package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomersDto {
//	private long customerId;
	private String customerName;
	private String emailId;
	private String password;
	private long contactNumber;

}
