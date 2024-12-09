package com.cpsc471g6.scplan.controller;

import com.cpsc471g6.scplan.dto.WorksOnDto;
import com.cpsc471g6.scplan.service.WorksOnService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/works-on")
public class WorksOnController {

	private final WorksOnService worksOnService;

	/**
	 * Create a new WorksOn relationship
	 */
	@PostMapping
	public ResponseEntity<WorksOnDto> createWorksOn(@RequestBody WorksOnDto worksOnDto) {
		WorksOnDto createdWorksOn = worksOnService.createWorksOn(worksOnDto);
		return new ResponseEntity<>(createdWorksOn, HttpStatus.CREATED);
	}

	/**
	 * Get a WorksOn relationship by project ID and employee ID
	 */
	@GetMapping("/{projectId}/{employeeId}")
	public ResponseEntity<WorksOnDto> getWorksOnById(@PathVariable int projectId, @PathVariable int employeeId) {
		WorksOnDto worksOn = worksOnService.getWorksOnById(projectId, employeeId);
		return ResponseEntity.ok(worksOn);
	}

	/**
	 * Get all WorksOn relationships for a specific project
	 */
	@GetMapping("/project/{projectId}")
	public ResponseEntity<List<WorksOnDto>> getAllWorksOnByProject(@PathVariable int projectId) {
		List<WorksOnDto> worksOnList = worksOnService.getAllWorksOnByProject(projectId);
		return ResponseEntity.ok(worksOnList);
	}

	/**
	 * Get all WorksOn relationships for a specific employee
	 */
	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<List<WorksOnDto>> getAllWorksOnByEmployee(@PathVariable int employeeId) {
		List<WorksOnDto> worksOnList = worksOnService.getAllWorksOnByEmployee(employeeId);
		return ResponseEntity.ok(worksOnList);
	}

	/**
	 * Get all WorksOn relationships
	 */
	@GetMapping
	public ResponseEntity<List<WorksOnDto>> getAllWorksOn() {
		List<WorksOnDto> worksOnList = worksOnService.getAllWorksOn();
		return ResponseEntity.ok(worksOnList);
	}

	/**
	 * Update an existing WorksOn relationship
	 */
	@PutMapping("/{projectId}/{employeeId}")
	public ResponseEntity<WorksOnDto> updateWorksOn(@PathVariable int projectId, @PathVariable int employeeId,
	                                                @RequestBody WorksOnDto worksOnDto) {
		WorksOnDto updatedWorksOn = worksOnService.updateWorksOn(projectId, employeeId, worksOnDto);
		return ResponseEntity.ok(updatedWorksOn);
	}

	/**
	 * Delete a WorksOn relationship by project ID and employee ID
	 */
	@DeleteMapping("/{projectId}/{employeeId}")
	public ResponseEntity<String> deleteWorksOn(@PathVariable int projectId, @PathVariable int employeeId) {
		worksOnService.deleteWorksOn(projectId, employeeId);
		return new ResponseEntity<>("WorksOn relationship deleted successfully.", HttpStatus.OK);
	}
}