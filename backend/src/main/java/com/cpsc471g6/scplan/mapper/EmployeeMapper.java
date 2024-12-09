package com.cpsc471g6.scplan.mapper;

import com.cpsc471g6.scplan.dto.EmployeeDto;
import com.cpsc471g6.scplan.dto.InHouseDesignerDto;
import com.cpsc471g6.scplan.dto.ProjectManagerDto;
import com.cpsc471g6.scplan.dto.FieldStaffDto;
import com.cpsc471g6.scplan.dto.DocumentControllerDto;
import com.cpsc471g6.scplan.entity.Employee;
import com.cpsc471g6.scplan.entity.InHouseDesigner;
import com.cpsc471g6.scplan.entity.ProjectManager;
import com.cpsc471g6.scplan.entity.FieldStaff;
import com.cpsc471g6.scplan.entity.DocumentController;

import java.util.Collections;
import java.util.stream.Collectors;

public class EmployeeMapper {

	// Map Employee entity to EmployeeDto
	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		if (employee == null) {
			throw new IllegalArgumentException("Employee entity cannot be null.");
		}

		return new EmployeeDto(
				employee.getId(),
				employee.getName(),
				employee.getDepartment(),
				employee.getReportedIssues() != null
						? employee.getReportedIssues().stream().map(IssuesMapper::mapToIssuesDto).collect(Collectors.toList())
						: Collections.emptyList(),
				employee.getWorksOnList() != null
						? employee.getWorksOnList().stream().map(WorksOnMapper::mapToWorksOnDto).collect(Collectors.toList())
						: Collections.emptyList(),
				employee.getInHouseDesigner() != null
						? InHouseDesignerMapper.mapToInHouseDesignerDto(employee.getInHouseDesigner())
						: null,
				employee.getProjectManager() != null
						? ProjectManagerMapper.mapToProjectManagerDto(employee.getProjectManager())
						: null,
				employee.getFieldStaff() != null
						? FieldStaffMapper.mapToFieldStaffDto(employee.getFieldStaff())
						: null,
				employee.getDocumentController() != null
						? DocumentControllerMapper.mapToDocumentControllerDto(employee.getDocumentController())
						: null
		);
	}

	// Map EmployeeDto to Employee entity
	public static Employee mapToEmployee(EmployeeDto employeeDto) {
		if (employeeDto == null) {
			throw new IllegalArgumentException("EmployeeDto cannot be null.");
		}

		Employee employee = new Employee();
		employee.setId(employeeDto.getId());
		employee.setName(employeeDto.getName());
		employee.setDepartment(employeeDto.getDepartment());

		// Map subentities
		if (employeeDto.getInHouseDesigner() != null) {
			InHouseDesigner inHouseDesigner = InHouseDesignerMapper.mapToInHouseDesigner(employeeDto.getInHouseDesigner());
			inHouseDesigner.setEmployee(employee);
			employee.setInHouseDesigner(inHouseDesigner);
		}

		if (employeeDto.getProjectManager() != null) {
			ProjectManager projectManager = ProjectManagerMapper.mapToProjectManager(employeeDto.getProjectManager());
			projectManager.setEmployee(employee);
			employee.setProjectManager(projectManager);
		}

		if (employeeDto.getFieldStaff() != null) {
			FieldStaff fieldStaff = FieldStaffMapper.mapToFieldStaff(employeeDto.getFieldStaff());
			fieldStaff.setEmployee(employee);
			employee.setFieldStaff(fieldStaff);
		}

		if (employeeDto.getDocumentController() != null) {
			DocumentController documentController = DocumentControllerMapper.mapToDocumentController(employeeDto.getDocumentController());
			documentController.setEmployee(employee);
			employee.setDocumentController(documentController);
		}

		// Issues and WorksOn relationships should be handled in the service layer
		return employee;
	}
}