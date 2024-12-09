package com.cpsc471g6.scplan.mapper;

import com.cpsc471g6.scplan.dto.IssuesDto;
import com.cpsc471g6.scplan.entity.Employee;
import com.cpsc471g6.scplan.entity.Issues;
import com.cpsc471g6.scplan.entity.Project;

public class IssuesMapper {

	// Map Issues entity to IssuesDto
	public static IssuesDto mapToIssuesDto(Issues issues) {
		return new IssuesDto(
				issues.getId(),
				issues.getDescription(),
				issues.getStatus(),
				issues.getProject() != null ? ProjectMapper.mapToProjectDto(issues.getProject()) : null,
				issues.getReportedBy() != null ? EmployeeMapper.mapToEmployeeDto(issues.getReportedBy()) : null
		);
	}

	// Map IssuesDto to Issues entity
	public static Issues mapToIssues(IssuesDto issuesDto) {
		Issues issues = new Issues();
		issues.setId(issuesDto.getId());
		issues.setDescription(issuesDto.getDescription());
		issues.setStatus(issuesDto.getStatus());
		// Project and ReportedBy should be set in the service layer
		return issues;
	}

	// Map IssuesDto to Issues entity with additional context (optional project and employee)
	public static Issues mapToIssues(IssuesDto issuesDto, Project project, Employee reportedBy) {
		Issues issues = new Issues();
		issues.setId(issuesDto.getId());
		issues.setDescription(issuesDto.getDescription());
		issues.setStatus(issuesDto.getStatus());
		issues.setProject(project); // Set the Project if available
		issues.setReportedBy(reportedBy); // Set the Employee if available
		return issues;
	}

	// Minimal mapping (excluding relationships)
	public static IssuesDto mapToIssuesDtoMinimal(Issues issues) {
		return new IssuesDto(
				issues.getId(),
				issues.getDescription(),
				issues.getStatus(),
				null, // Exclude Project
				null  // Exclude ReportedBy
		);
	}
}