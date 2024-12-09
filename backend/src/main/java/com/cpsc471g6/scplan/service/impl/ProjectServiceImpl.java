package com.cpsc471g6.scplan.service.impl;

import com.cpsc471g6.scplan.dto.ProjectDto;
import com.cpsc471g6.scplan.entity.Employee;
import com.cpsc471g6.scplan.entity.Project;
import com.cpsc471g6.scplan.exception.ResourceNotFoundException;
import com.cpsc471g6.scplan.mapper.ProjectMapper;
import com.cpsc471g6.scplan.repository.EmployeeRepository;
import com.cpsc471g6.scplan.repository.ProjectRepository;
import com.cpsc471g6.scplan.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class ProjectServiceImpl implements ProjectService {
	private ProjectRepository projectRepository;
	private EmployeeRepository employeeRepository;

	@Override
	public ProjectDto createProject(ProjectDto projectDto) {
		Project project = ProjectMapper.mapToProject(projectDto);

		// Set Design Lead if provided
		if (projectDto.getDesignLead() != null) {
			Employee employee = employeeRepository.findById(projectDto.getDesignLead().getEmployeeId())
					.orElseThrow(() -> new ResourceNotFoundException("Employee with ID " + projectDto.getDesignLead().getEmployeeId() + " not found."));

			if (employee.getInHouseDesigner() == null) {
				throw new ResourceNotFoundException("Employee with ID " + projectDto.getDesignLead().getEmployeeId() + " is not an In-House Designer.");
			}

			project.setDesignLead(employee.getInHouseDesigner());
		}

		Project savedProject = projectRepository.save(project);
		return ProjectMapper.mapToProjectDto(savedProject);
	}

	@Override
	public ProjectDto getProjectById(int projectId) {
		Project project = projectRepository.findById(projectId).orElseThrow(
				() -> new ResourceNotFoundException("Project " + projectId + " not found.")
		);
		return ProjectMapper.mapToProjectDto(project);
	}

	@Override
	public List<ProjectDto> getAllProjects() {
		List<Project> projects = projectRepository.findAll();
		return projects.stream().map(ProjectMapper::mapToProjectDto).collect(Collectors.toList());
	}

	@Override
	public ProjectDto updateProject(int projectId, ProjectDto projectDto) {
		Project project = projectRepository.findById(projectId).orElseThrow(
				() -> new ResourceNotFoundException("Project " + projectId + " not found.")
		);

		project.setYear(projectDto.getYear());
		project.setProjectName(projectDto.getProjectName());
		project.setProjectStatus(projectDto.getProjectStatus());

		if (projectDto.getDesignLead() != null) {
			Employee employee = employeeRepository.findById(projectDto.getDesignLead().getEmployeeId())
					.orElseThrow(() -> new ResourceNotFoundException("Employee with ID " + projectDto.getDesignLead().getEmployeeId() + " not found."));

			if (employee.getInHouseDesigner() == null) {
				throw new ResourceNotFoundException("Employee with ID " + projectDto.getDesignLead().getEmployeeId() + " is not an In-House Designer.");
			}

			project.setDesignLead(employee.getInHouseDesigner());
		} else {
			project.setDesignLead(null); // Unset the design lead if not provided
		}

		Project updatedProjectObj = projectRepository.save(project);
		return ProjectMapper.mapToProjectDto(updatedProjectObj);
	}

	@Override
	public void deleteProject(int projectId) {
		Project project = projectRepository.findById(projectId).orElseThrow(
				() -> new ResourceNotFoundException("Project " + projectId + " not found.")
		);

		projectRepository.deleteById(projectId);
	}
}