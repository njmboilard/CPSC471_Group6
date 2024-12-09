package com.cpsc471g6.scplan.service.impl;

import com.cpsc471g6.scplan.dto.WorksOnDto;
import com.cpsc471g6.scplan.entity.Employee;
import com.cpsc471g6.scplan.entity.Project;
import com.cpsc471g6.scplan.entity.WorksOn;
import com.cpsc471g6.scplan.entity.WorksOnId;
import com.cpsc471g6.scplan.exception.ResourceNotFoundException;
import com.cpsc471g6.scplan.mapper.WorksOnMapper;
import com.cpsc471g6.scplan.repository.EmployeeRepository;
import com.cpsc471g6.scplan.repository.ProjectRepository;
import com.cpsc471g6.scplan.repository.WorksOnRepository;
import com.cpsc471g6.scplan.service.WorksOnService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WorksOnServiceImpl implements WorksOnService {

	private final WorksOnRepository worksOnRepository;
	private final ProjectRepository projectRepository;
	private final EmployeeRepository employeeRepository;

	/**
	 * Create a new WorksOn relationship
	 */
	@Override
	public WorksOnDto createWorksOn(WorksOnDto worksOnDto) {
		// Fetch Project
		Project project = projectRepository.findById(worksOnDto.getProjectId()).orElseThrow(
				() -> new ResourceNotFoundException("Project not found with ID: " + worksOnDto.getProjectId())
		);

		// Fetch Employee
		Employee employee = employeeRepository.findById(worksOnDto.getEmployeeId()).orElseThrow(
				() -> new ResourceNotFoundException("Employee not found with ID: " + worksOnDto.getEmployeeId())
		);

		// Map DTO to Entity
		WorksOn worksOn = WorksOnMapper.mapToWorksOn(worksOnDto);
		worksOn.setProject(project);
		worksOn.setEmployee(employee);

		// Save Entity
		WorksOn savedWorksOn = worksOnRepository.save(worksOn);

		// Map Entity to DTO
		return WorksOnMapper.mapToWorksOnDto(savedWorksOn);
	}

	/**
	 * Get a WorksOn relationship by project ID and employee ID
	 */
	@Override
	public WorksOnDto getWorksOnById(int projectId, int employeeId) {
		WorksOnId worksOnId = new WorksOnId(projectId, employeeId);
		WorksOn worksOn = worksOnRepository.findById(worksOnId).orElseThrow(
				() -> new ResourceNotFoundException("WorksOn relationship not found for Project ID: "
						+ projectId + " and Employee ID: " + employeeId)
		);
		return WorksOnMapper.mapToWorksOnDto(worksOn);
	}

	/**
	 * Get all WorksOn relationships for a specific project
	 */
	@Override
	public List<WorksOnDto> getAllWorksOnByProject(int projectId) {
		return worksOnRepository.findAll().stream()
				.filter(worksOn -> worksOn.getProject().getId() == projectId)
				.map(WorksOnMapper::mapToWorksOnDto)
				.collect(Collectors.toList());
	}

	/**
	 * Get all WorksOn relationships for a specific employee
	 */
	@Override
	public List<WorksOnDto> getAllWorksOnByEmployee(int employeeId) {
		return worksOnRepository.findAll().stream()
				.filter(worksOn -> worksOn.getEmployee().getId() == employeeId)
				.map(WorksOnMapper::mapToWorksOnDto)
				.collect(Collectors.toList());
	}

	/**
	 * Get all WorksOn relationships
	 */
	@Override
	public List<WorksOnDto> getAllWorksOn() {
		return worksOnRepository.findAll().stream()
				.map(WorksOnMapper::mapToWorksOnDto)
				.collect(Collectors.toList());
	}

	/**
	 * Update an existing WorksOn relationship
	 */
	@Override
	public WorksOnDto updateWorksOn(int projectId, int employeeId, WorksOnDto worksOnDto) {
		WorksOnId worksOnId = new WorksOnId(projectId, employeeId);
		WorksOn existingWorksOn = worksOnRepository.findById(worksOnId).orElseThrow(
				() -> new ResourceNotFoundException("WorksOn relationship not found for Project ID: "
						+ projectId + " and Employee ID: " + employeeId)
		);

		// Update non-ID fields (if applicable, none shown in your model)
		// Since `WorksOn` is a relationship, it doesn't typically have fields that are updated

		// Save Entity
		WorksOn updatedWorksOn = worksOnRepository.save(existingWorksOn);

		// Map Entity to DTO
		return WorksOnMapper.mapToWorksOnDto(updatedWorksOn);
	}

	/**
	 * Delete a WorksOn relationship by project ID and employee ID
	 */
	@Override
	public void deleteWorksOn(int projectId, int employeeId) {
		WorksOnId worksOnId = new WorksOnId(projectId, employeeId);
		WorksOn worksOn = worksOnRepository.findById(worksOnId).orElseThrow(
				() -> new ResourceNotFoundException("WorksOn relationship not found for Project ID: "
						+ projectId + " and Employee ID: " + employeeId)
		);

		worksOnRepository.delete(worksOn);
	}
}