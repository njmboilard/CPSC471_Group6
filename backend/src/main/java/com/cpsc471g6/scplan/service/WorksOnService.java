package com.cpsc471g6.scplan.service;

import com.cpsc471g6.scplan.dto.WorksOnDto;

import java.util.List;

public interface WorksOnService {
	// Create a new WorksOn relationship
	WorksOnDto createWorksOn(WorksOnDto worksOnDto);

	// Get a WorksOn relationship by project ID and employee ID
	WorksOnDto getWorksOnById(int projectId, int employeeId);

	// Get all WorksOn relationships for a specific project
	List<WorksOnDto> getAllWorksOnByProject(int projectId);

	// Get all WorksOn relationships for a specific employee
	List<WorksOnDto> getAllWorksOnByEmployee(int employeeId);

	// Get all WorksOn relationships
	List<WorksOnDto> getAllWorksOn();

	// Update an existing WorksOn relationship
	WorksOnDto updateWorksOn(int projectId, int employeeId, WorksOnDto worksOnDto);

	// Delete a WorksOn relationship by project ID and employee ID
	void deleteWorksOn(int projectId, int employeeId);
}