package com.cpsc471g6.scplan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDto {
	private int id;                         // ID of the Employee
	private String name;                    // Name of the Employee
	private String department;              // Department the Employee belongs to
	private List<IssuesDto> issues;         // List of issues reported by the Employee
	private List<WorksOnDto> worksOn;       // List of projects the Employee works on

	// Subentity fields
	private InHouseDesignerDto inHouseDesigner;
	private ProjectManagerDto projectManager;
	private FieldStaffDto fieldStaff;
	private DocumentControllerDto documentController;
}
