package com.cpsc471g6.scplan.controller;

import com.cpsc471g6.scplan.dto.*;
import com.cpsc471g6.scplan.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private final EmployeeService employeeService;

	// Create Employee with Subentities
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployeeWithSubentities(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto savedEmployee = employeeService.createEmployeeWithSubentities(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}

	// Get Employee by ID
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable int id) {
		EmployeeDto employee = employeeService.getEmployeeById(id);
		return ResponseEntity.ok(employee);
	}

	// Get All Employees
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
		List<EmployeeDto> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}

	// Update Employee with Subentities
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable int id, @RequestBody EmployeeDto updatedEmployee) {
		EmployeeDto updatedEmployeeDto = employeeService.updateEmployee(id, updatedEmployee);
		return ResponseEntity.ok(updatedEmployeeDto);
	}

	// Delete Employee by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok("Employee deleted successfully.");
	}

	// Get
	@GetMapping("/{employeeId}/in-house-designer")
	public ResponseEntity<InHouseDesignerDto> getInHouseDesignerByEmployeeId(@PathVariable int employeeId) {
		InHouseDesignerDto inHouseDesigner = employeeService.getInHouseDesignerByEmployeeId(employeeId);
		return ResponseEntity.ok(inHouseDesigner);
	}

	@GetMapping("/{employeeId}/project-manager")
	public ResponseEntity<ProjectManagerDto> getProjectManagerByEmployeeId(@PathVariable int employeeId) {
		ProjectManagerDto projectManager = employeeService.getProjectManagerByEmployeeId(employeeId);
		return ResponseEntity.ok(projectManager);
	}

	@GetMapping("/{employeeId}/field-staff")
	public ResponseEntity<FieldStaffDto> getFieldStaffByEmployeeId(@PathVariable int employeeId) {
		FieldStaffDto fieldStaff = employeeService.getFieldStaffByEmployeeId(employeeId);
		return ResponseEntity.ok(fieldStaff);
	}

	@GetMapping("/{employeeId}/document-controller")
	public ResponseEntity<DocumentControllerDto> getDocumentControllerByEmployeeId(@PathVariable int employeeId) {
		DocumentControllerDto documentController = employeeService.getDocumentControllerByEmployeeId(employeeId);
		return ResponseEntity.ok(documentController);
	}
}