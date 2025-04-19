package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeesDto;
import com.example.demo.entity.Employees;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.repository.EmployeesRepository;

@Service
public class EmployeesServiceImpl implements EmployeesService {
	@Autowired
	private EmployeesRepository employeesRepository;

	@Override
	public EmployeesDto addEmployees(EmployeesDto employeesDto) {

		if (employeesDto != null) {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			String encode = bCryptPasswordEncoder.encode(employeesDto.getPassword());
			employeesDto.setPassword(encode);
			Employees employees = new Employees();
			BeanUtils.copyProperties(employeesDto, employees);
			employeesRepository.save(employees);
			BeanUtils.copyProperties(employees, employeesDto);
			return employeesDto;
		}
		throw new EmployeeNotFoundException("Not Added");

	}

	@Override
	public List<EmployeesDto> getAll() {
		List<EmployeesDto> listemplEmployeesDtos = new ArrayList<>();
		List<Employees> allEmployees = employeesRepository.findAll();
		if (allEmployees.isEmpty()) {
			throw new EmployeeNotFoundException("Employees Not Available");
		}
		allEmployees.forEach(i -> {
			EmployeesDto employeesDto = new EmployeesDto();
			BeanUtils.copyProperties(i, employeesDto);
			listemplEmployeesDtos.add(employeesDto);
		});
		return listemplEmployeesDtos;
	}

	@Override
	public EmployeesDto getEmployee(long employeeId) {
		Employees employee = employeesRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Invalid Id"));
		EmployeesDto employeesDto = new EmployeesDto();
		BeanUtils.copyProperties(employee, employeesDto);
		return employeesDto;
	}

	@Override
	public EmployeesDto deleteById(long employeeId) {
		employeesRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("Id Not found"));
		employeesRepository.deleteById(employeeId);
		return new EmployeesDto();
	}

	@Override
	public void deleteEmployee(long employeeId) {
		employeesRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("Invalid Id"));
		employeesRepository.deleteById(employeeId);

	}

	@Override
	public String delete(long employeeId) {
		employeesRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("Id Mismatch"));
		employeesRepository.deleteById(employeeId);
		return "Deleted Succesfully";
	}

	@Override
	public EmployeesDto updateEmployee(EmployeesDto employeesDto) {

		Employees employee = employeesRepository.findById(employeesDto.getEmployeeId())
				.orElseThrow(() -> new EmployeeNotFoundException("ID not Get"));
		BeanUtils.copyProperties(employeesDto, employee);
		employeesRepository.save(employee);
		BeanUtils.copyProperties(employee, employeesDto);
		return employeesDto;
	}

	@Override
	public EmployeesDto update(EmployeesDto employeesDto) {
		Employees employees = employeesRepository.findById(employeesDto.getEmployeeId())
				.orElseThrow(() -> new EmployeeNotFoundException("ID NOT MATCHING"));
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String encode = bCryptPasswordEncoder.encode(employeesDto.getPassword());
		employeesDto.setPassword(encode);
		BeanUtils.copyProperties(employeesDto, employees);
		employeesRepository.save(employees);
		BeanUtils.copyProperties(employees, employeesDto);
		return employeesDto;

	}

	@Override
	public EmployeesDto getByPassword(long employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
