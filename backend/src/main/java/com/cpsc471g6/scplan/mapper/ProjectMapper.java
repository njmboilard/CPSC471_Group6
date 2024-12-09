package com.cpsc471g6.scplan.mapper;

import com.cpsc471g6.scplan.dto.*;
import com.cpsc471g6.scplan.entity.*;

import java.util.stream.Collectors;

public class ProjectMapper {

	// Convert Project entity to ProjectDto
	public static ProjectDto mapToProjectDto(Project project) {
		return new ProjectDto(
				project.getId(),
				project.getYear(),
				project.getProjectName(),
				project.getProjectStatus(),
				project.getDesignLead() != null ? InHouseDesignerMapper.mapToInHouseDesignerDto(project.getDesignLead()) : null, // Map design lead ID
				project.getAssignedPlans() != null && !project.getAssignedPlans().isEmpty()
						? project.getAssignedPlans().stream()
						.map(AssignedPlanMapper::mapToAssignedPlanDto)
						.collect(Collectors.toList())
						: null, // Map assigned plans
				project.getIssues() != null && !project.getIssues().isEmpty()
						? project.getIssues().stream()
						.map(IssuesMapper::mapToIssuesDto)
						.collect(Collectors.toList())
						: null, // Map issues
				project.getWorksOnList() != null && !project.getWorksOnList().isEmpty()
						? project.getWorksOnList().stream()
						.map(WorksOnMapper::mapToWorksOnDto)
						.collect(Collectors.toList())
						: null, // Map works on
				project.getContractedOnList() != null && !project.getContractedOnList().isEmpty()
						? project.getContractedOnList().stream()
						.map(ContractedOnMapper::mapToContractedOnDto)
						.collect(Collectors.toList())
						: null // Map contracted on
		);
	}

	// Convert ProjectDto to Project entity
	public static Project mapToProject(ProjectDto projectDto) {
		Project project = new Project();
		project.setId(projectDto.getId());
		project.setYear(projectDto.getYear());
		project.setProjectName(projectDto.getProjectName());
		project.setProjectStatus(projectDto.getProjectStatus());
		// Note: Design Lead mapping should be handled in the service layer as it involves fetching the entity
		return project;
	}
}