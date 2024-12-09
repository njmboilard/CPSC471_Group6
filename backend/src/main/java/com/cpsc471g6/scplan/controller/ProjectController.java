package com.cpsc471g6.scplan.controller;

import com.cpsc471g6.scplan.dto.ProjectDto;
import com.cpsc471g6.scplan.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/projects")
public class ProjectController {
	private final ProjectService projectService;

	// Create a new project
	@PostMapping
	public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto projectDto) {
		ProjectDto createdProject = projectService.createProject(projectDto);
		return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
	}

	// Get a project by ID
	@GetMapping("/{projectId}")
	public ResponseEntity<ProjectDto> getProjectById(@PathVariable int projectId) {
		ProjectDto project = projectService.getProjectById(projectId);
		return ResponseEntity.ok(project);
	}

	// Get all projects
	@GetMapping
	public ResponseEntity<List<ProjectDto>> getAllProjects() {
		List<ProjectDto> projects = projectService.getAllProjects();
		return ResponseEntity.ok(projects);
	}

	// Update an existing project
	@PutMapping("/{projectId}")
	public ResponseEntity<ProjectDto> updateProject(@PathVariable int projectId, @RequestBody ProjectDto projectDto) {
		ProjectDto updatedProject = projectService.updateProject(projectId, projectDto);
		return ResponseEntity.ok(updatedProject);
	}

	// Delete a project
	@DeleteMapping("/{projectId}")
	public ResponseEntity<String> deleteProject(@PathVariable int projectId) {
		projectService.deleteProject(projectId);
		return ResponseEntity.ok("Project " + projectId + " deleted successfully.");
	}
}