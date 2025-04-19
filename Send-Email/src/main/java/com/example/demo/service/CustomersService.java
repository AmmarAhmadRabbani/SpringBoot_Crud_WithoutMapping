package com.example.demo.service;

import java.io.IOException;

import com.example.demo.dto.CustomersDto;
import com.example.demo.dto.CustomersFileDto;

public interface CustomersService {
	public CustomersDto registerCustomers(CustomersDto customersDto);

	public CustomersDto registerWithCredentials(CustomersDto customersDto);

	public CustomersDto registerwithCredentilasFileAttached(CustomersDto customersDto, String attachment)
			throws IOException;

	public String registerwithCredentilasWithFileAttached(CustomersFileDto customersFileDto) throws IOException;

	public CustomersDto registerWithPasswordBCryptCredentials(CustomersDto customersDto);

	public CustomersDto registCustomersDtoWithAllAbove(CustomersDto customersDto);

}
