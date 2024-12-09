package com.cpsc471g6.scplan.controller;

import com.cpsc471g6.scplan.dto.IssuesDto;
import com.cpsc471g6.scplan.service.IssuesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/issues")
public class IssuesController {

	private final IssuesService issuesService;

	/**
	 * Create a new issue
	 */
	@PostMapping
	public ResponseEntity<IssuesDto> createIssue(@RequestBody IssuesDto issuesDto) {
		IssuesDto createdIssue = issuesService.createIssue(issuesDto);
		return new ResponseEntity<>(createdIssue, HttpStatus.CREATED);
	}

	/**
	 * Get an issue by ID
	 */
	@GetMapping("/{id}")
	public ResponseEntity<IssuesDto> getIssueById(@PathVariable int id) {
		IssuesDto issue = issuesService.getIssueById(id);
		return ResponseEntity.ok(issue);
	}

	/**
	 * Get all issues
	 */
	@GetMapping
	public ResponseEntity<List<IssuesDto>> getAllIssues() {
		List<IssuesDto> issues = issuesService.getAllIssues();
		return ResponseEntity.ok(issues);
	}

	/**
	 * Get all issues for a specific project
	 */
	@GetMapping("/projects/{projectId}")
	public ResponseEntity<List<IssuesDto>> getIssuesByProject(@PathVariable int projectId) {
		List<IssuesDto> issues = issuesService.getIssuesByProject(projectId);
		return ResponseEntity.ok(issues);
	}

	/**
	 * Get all issues reported by a specific employee
	 */
	@GetMapping("/employees/{employeeId}")
	public ResponseEntity<List<IssuesDto>> getIssuesByReporter(@PathVariable int employeeId) {
		List<IssuesDto> issues = issuesService.getIssuesByReporter(employeeId);
		return ResponseEntity.ok(issues);
	}

	/**
	 * Update an issue by ID
	 */
	@PutMapping("/{id}")
	public ResponseEntity<IssuesDto> updateIssue(@PathVariable int id, @RequestBody IssuesDto issuesDto) {
		IssuesDto updatedIssue = issuesService.updateIssue(id, issuesDto);
		return ResponseEntity.ok(updatedIssue);
	}

	/**
	 * Delete an issue by ID
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteIssue(@PathVariable int id) {
		issuesService.deleteIssue(id);
		return new ResponseEntity<>("Issue deleted successfully", HttpStatus.OK);
	}
}