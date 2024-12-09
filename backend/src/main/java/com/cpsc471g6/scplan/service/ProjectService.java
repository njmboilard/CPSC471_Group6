package com.cpsc471g6.scplan.service;

import com.cpsc471g6.scplan.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
	ProjectDto createProject(ProjectDto projectDto);
	ProjectDto getProjectById(int projectId);
	List<ProjectDto> getAllProjects();
	ProjectDto updateProject(int projectId, ProjectDto projectDto);
	void deleteProject(int projectId);
}
