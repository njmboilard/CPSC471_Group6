package com.cpsc471g6.scplan.service.impl;

import com.cpsc471g6.scplan.dto.IssuesDto;
import com.cpsc471g6.scplan.entity.Employee;
import com.cpsc471g6.scplan.entity.Issues;
import com.cpsc471g6.scplan.entity.Project;
import com.cpsc471g6.scplan.exception.ResourceNotFoundException;
import com.cpsc471g6.scplan.mapper.IssuesMapper;
import com.cpsc471g6.scplan.repository.EmployeeRepository;
import com.cpsc471g6.scplan.repository.IssuesRepository;
import com.cpsc471g6.scplan.repository.ProjectRepository;
import com.cpsc471g6.scplan.service.IssuesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IssuesServiceImpl implements IssuesService {

	private final IssuesRepository issuesRepository;
	private final ProjectRepository projectRepository;
	private final EmployeeRepository employeeRepository;

	@Override
	public IssuesDto createIssue(IssuesDto issuesDto) {
		// Fetch the related project
		Project project = projectRepository.findById(issuesDto.getProject().getId())
				.orElseThrow(() -> new ResourceNotFoundException("Project not found with ID: " + issuesDto.getProject().getId()));

		// Fetch the related employee
		Employee reportedBy = employeeRepository.findById(issuesDto.getReportedBy().getId())
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + issuesDto.getReportedBy().getId()));

		// Map DTO to entity
		Issues issues = IssuesMapper.mapToIssues(issuesDto);
		issues.setProject(project);
		issues.setReportedBy(reportedBy);

		// Save the entity
		Issues savedIssue = issuesRepository.save(issues);

		// Return the saved issue as a DTO
		return IssuesMapper.mapToIssuesDto(savedIssue);
	}

	@Override
	public IssuesDto getIssueById(int issueId) {
		Issues issues = issuesRepository.findById(issueId)
				.orElseThrow(() -> new ResourceNotFoundException("Issue not found with ID: " + issueId));
		return IssuesMapper.mapToIssuesDto(issues);
	}

	@Override
	public List<IssuesDto> getIssuesByProject(int projectId) {
		return issuesRepository.findAll().stream()
				.filter(issues -> issues.getProject().getId() == projectId)
				.map(IssuesMapper::mapToIssuesDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<IssuesDto> getIssuesByReporter(int employeeId) {
		return issuesRepository.findAll().stream()
				.filter(issues -> issues.getReportedBy().getId() == employeeId)
				.map(IssuesMapper::mapToIssuesDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<IssuesDto> getAllIssues() {
		return issuesRepository.findAll().stream()
				.map(IssuesMapper::mapToIssuesDto)
				.collect(Collectors.toList());
	}

	@Override
	public IssuesDto updateIssue(int issueId, IssuesDto issuesDto) {
		// Fetch the existing issue
		Issues existingIssue = issuesRepository.findById(issueId)
				.orElseThrow(() -> new ResourceNotFoundException("Issue not found with ID: " + issueId));

		// Fetch and set updated project if provided
		if (issuesDto.getProject() != null) {
			Project project = projectRepository.findById(issuesDto.getProject().getId())
					.orElseThrow(() -> new ResourceNotFoundException("Project not found with ID: " + issuesDto.getProject().getId()));
			existingIssue.setProject(project);
		}

		// Fetch and set updated employee if provided
		if (issuesDto.getReportedBy() != null) {
			Employee reportedBy = employeeRepository.findById(issuesDto.getReportedBy().getId())
					.orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + issuesDto.getReportedBy().getId()));
			existingIssue.setReportedBy(reportedBy);
		}

		// Update non-entity fields
		existingIssue.setDescription(issuesDto.getDescription());
		existingIssue.setStatus(issuesDto.getStatus());

		// Save and return the updated issue
		Issues updatedIssue = issuesRepository.save(existingIssue);
		return IssuesMapper.mapToIssuesDto(updatedIssue);
	}

	@Override
	public void deleteIssue(int issueId) {
		Issues existingIssue = issuesRepository.findById(issueId)
				.orElseThrow(() -> new ResourceNotFoundException("Issue not found with ID: " + issueId));
		issuesRepository.delete(existingIssue);
	}
}