package com.example.demo.service;

import java.io.IOException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.utils.FileUtils;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto, MultipartFile multipartFile) throws IOException {
		if (employeeDto != null) {

			BeanUtils.copyProperties(employeeDto, employee);
			employee.setImageData(
					Employee.builder().imageData(FileUtils.compressFile(multipartFile.getBytes())).build());
			employee.getImageData(
					Employee.builder().imageData(FileUtils.compressFile(multipartFile.getBytes())).build());
		return null;
	}

}
