package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeesDto;
import com.example.demo.response.SuccessResponse;
import com.example.demo.service.EmployeesService;

@RestController
public class EmployeesController {
	@Autowired
	private EmployeesService employeesService;

	@PostMapping("/AddEmployees")
	public ResponseEntity<SuccessResponse> addEmployees(@RequestBody EmployeesDto employeesDto) {
		EmployeesDto employees = employeesService.addEmployees(employeesDto);
		if (employees != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "added", employees), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "Not added Sucessful", null), HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/GetAll")
	public ResponseEntity<SuccessResponse> getAll() {
		List<EmployeesDto> all = employeesService.getAll();
		if (all.isEmpty()) {
			return new ResponseEntity<>(new SuccessResponse(true, "Getting Failed", null), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(new SuccessResponse(false, "Successful", all), HttpStatus.OK);
	}

	@GetMapping("/GetEmployee/{employeeId}")
	public ResponseEntity<SuccessResponse> getEmployee(@PathVariable long employeeId) {
		EmployeesDto employee = employeesService.getEmployee(employeeId);
		if (employee != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "Sucessully got", employee), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "Failed to get", null), HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getEmployee/{employeeId}")
	public ResponseEntity<SuccessResponse> getByPassword(@PathVariable long employeeId) {
		EmployeesDto employee = employeesService.getByPassword(employeeId);
		if (employee != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "Sucessully got", employee), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "Failed to get", null), HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/updateEmployee")
	public ResponseEntity<SuccessResponse> updateEmployee(@RequestBody EmployeesDto employeesDto) {
		EmployeesDto updateEmployee = employeesService.updateEmployee(employeesDto);
		if (updateEmployee != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "Updated", updateEmployee), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "Not Updated", null), HttpStatus.BAD_REQUEST);

	}

	@PutMapping("/UpdateEmployeePasss")
	public ResponseEntity<SuccessResponse> update(@RequestBody EmployeesDto employeesDto) {
		EmployeesDto update = employeesService.update(employeesDto);
		if (update != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "Updated Sucessful", update), HttpStatus.OK);

		}
		return new ResponseEntity<>(new SuccessResponse(true, "Unsucessful", null), HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping("/deleteById/{employeeId}")
	public ResponseEntity<SuccessResponse> deleteById(@PathVariable long employeeId) {
		EmployeesDto deleteById = employeesService.deleteById(employeeId);
		if (deleteById != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "Deleted", deleteById), HttpStatus.OK);

		}
		return new ResponseEntity<>(new SuccessResponse(true, "Not Deleted", null), HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping("/DeleteById/{employeeId}")
	public ResponseEntity<SuccessResponse> delete(@PathVariable long employeeId) {
		String delete = employeesService.delete(employeeId);

		return new ResponseEntity<>(new SuccessResponse(false, "DELETD", delete), HttpStatus.OK);
	}

	@DeleteMapping("/{employeeId}")
	public ResponseEntity<SuccessResponse> deleteEmployee(@PathVariable long employeeId) {
		employeesService.deleteEmployee(employeeId);
		return new ResponseEntity<>(new SuccessResponse(false, "Deleted", null), HttpStatus.OK);

	}

}
