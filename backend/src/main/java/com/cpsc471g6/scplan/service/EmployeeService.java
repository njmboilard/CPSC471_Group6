package com.cpsc471g6.scplan.service;

import com.cpsc471g6.scplan.dto.*;

import java.util.List;

public interface EmployeeService {
	// Create an Employee along with any associated subentities
	EmployeeDto createEmployeeWithSubentities(EmployeeDto employeeDto);

	// Get an Employee by ID
	EmployeeDto getEmployeeById(int id);

	// Get all Employees
	List<EmployeeDto> getAllEmployees();

	// Update Employee (including associated subentities)
	EmployeeDto updateEmployee(int employeeId, EmployeeDto updatedEmployee);

	// Delete Employee (cascade deletes associated subentities)
	void deleteEmployee(int employeeId);

	// Get Employees by Subentities
	InHouseDesignerDto getInHouseDesignerByEmployeeId(int employeeId);
	ProjectManagerDto getProjectManagerByEmployeeId(int employeeId);
	FieldStaffDto getFieldStaffByEmployeeId(int employeeId);
	DocumentControllerDto getDocumentControllerByEmployeeId(int employeeId);
}