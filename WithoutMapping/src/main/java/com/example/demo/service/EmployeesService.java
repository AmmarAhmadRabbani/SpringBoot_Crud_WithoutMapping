package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EmployeesDto;

public interface EmployeesService {
	public EmployeesDto addEmployees(EmployeesDto employeesDto);

	public List<EmployeesDto> getAll();

	public EmployeesDto getEmployee(long employeeId);

	public EmployeesDto getByPassword(long employeeId);

	public EmployeesDto deleteById(long employeeId);

	public void deleteEmployee(long employeeId);

	public String delete(long employeeId);

	public EmployeesDto updateEmployee(EmployeesDto employeesDto);

	public EmployeesDto update(EmployeesDto employeesDto);

	

}
