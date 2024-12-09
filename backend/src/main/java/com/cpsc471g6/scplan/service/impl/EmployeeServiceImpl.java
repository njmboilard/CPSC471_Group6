package com.cpsc471g6.scplan.service.impl;

import com.cpsc471g6.scplan.dto.*;
import com.cpsc471g6.scplan.entity.*;
import com.cpsc471g6.scplan.exception.ResourceNotFoundException;
import com.cpsc471g6.scplan.mapper.*;
import com.cpsc471g6.scplan.repository.EmployeeRepository;
import com.cpsc471g6.scplan.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployeeWithSubentities(EmployeeDto employeeDto) {
		// Map EmployeeDto to Employee entity
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

		// Save the Employee entity (cascade saves subentities)
		Employee savedEmployee = employeeRepository.save(employee);

		// Map the saved Employee entity back to EmployeeDto and return
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(int id) {
		// Fetch Employee by ID
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));

		// Map Employee entity to EmployeeDto and return
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		// Fetch all Employees
		List<Employee> employees = employeeRepository.findAll();

		// Map each Employee entity to EmployeeDto
		return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(int employeeId, EmployeeDto updatedEmployee) {
		// Fetch existing Employee
		Employee existingEmployee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + employeeId));

		// Map updatedEmployee DTO to existing Employee entity
		existingEmployee.setName(updatedEmployee.getName());
		existingEmployee.setDepartment(updatedEmployee.getDepartment());

		// Update subentities
		if (updatedEmployee.getInHouseDesigner() != null) {
			InHouseDesigner inHouseDesigner = InHouseDesignerMapper.mapToInHouseDesigner(updatedEmployee.getInHouseDesigner());
			inHouseDesigner.setEmployee(existingEmployee);
			existingEmployee.setInHouseDesigner(inHouseDesigner);
		}

		if (updatedEmployee.getProjectManager() != null) {
			ProjectManager projectManager = ProjectManagerMapper.mapToProjectManager(updatedEmployee.getProjectManager());
			projectManager.setEmployee(existingEmployee);
			existingEmployee.setProjectManager(projectManager);
		}

		if (updatedEmployee.getFieldStaff() != null) {
			FieldStaff fieldStaff = FieldStaffMapper.mapToFieldStaff(updatedEmployee.getFieldStaff());
			fieldStaff.setEmployee(existingEmployee);
			existingEmployee.setFieldStaff(fieldStaff);
		}

		if (updatedEmployee.getDocumentController() != null) {
			DocumentController documentController = DocumentControllerMapper.mapToDocumentController(updatedEmployee.getDocumentController());
			documentController.setEmployee(existingEmployee);
			existingEmployee.setDocumentController(documentController);
		}

		// Save updated Employee
		Employee savedEmployee = employeeRepository.save(existingEmployee);

		// Map saved Employee to EmployeeDto and return
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		// Check if Employee exists
		if (!employeeRepository.existsById(employeeId)) {
			throw new ResourceNotFoundException("Employee not found with ID: " + employeeId);
		}

		// Delete Employee (cascade deletes subentities)
		employeeRepository.deleteById(employeeId);
	}

	@Override
	public InHouseDesignerDto getInHouseDesignerByEmployeeId(int employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee " + employeeId + " not found."));
		if (employee.getInHouseDesigner() == null) {
			throw new ResourceNotFoundException("In-House Designer not found for Employee " + employeeId + ".");
		}
		return InHouseDesignerMapper.mapToInHouseDesignerDto(employee.getInHouseDesigner());
	}

	@Override
	public ProjectManagerDto getProjectManagerByEmployeeId(int employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee " + employeeId + " not found."));
		if (employee.getProjectManager() == null) {
			throw new ResourceNotFoundException("Project Manager not found for Employee " + employeeId + ".");
		}
		return ProjectManagerMapper.mapToProjectManagerDto(employee.getProjectManager());
	}

	@Override
	public FieldStaffDto getFieldStaffByEmployeeId(int employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee " + employeeId + " not found."));
		if (employee.getFieldStaff() == null) {
			throw new ResourceNotFoundException("Field Staff not found for Employee " + employeeId + ".");
		}
		return FieldStaffMapper.mapToFieldStaffDto(employee.getFieldStaff());
	}

	@Override
	public DocumentControllerDto getDocumentControllerByEmployeeId(int employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee " + employeeId + " not found."));
		if (employee.getDocumentController() == null) {
			throw new ResourceNotFoundException("Document Controller not found for Employee " + employeeId + ".");
		}
		return DocumentControllerMapper.mapToDocumentControllerDto(employee.getDocumentController());
	}

}
