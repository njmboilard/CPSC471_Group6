package com.cpsc471g6.scplan.controller;

import com.cpsc471g6.scplan.dto.AssignedPlanDto;
import com.cpsc471g6.scplan.service.AssignedPlanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/assigned-plans")
public class AssignedPlanController {

	private final AssignedPlanService assignedPlanService;

	// Create a new AssignedPlan
	@PostMapping
	public ResponseEntity<AssignedPlanDto> createAssignedPlan(@RequestBody AssignedPlanDto assignedPlanDto) {
		AssignedPlanDto createdPlan = assignedPlanService.createAssignedPlan(assignedPlanDto);
		return new ResponseEntity<>(createdPlan, HttpStatus.CREATED);
	}

	// Get AssignedPlan by composite key (chopCode, mileage, drawingNumber)
	@GetMapping("/{chopCode}/{mileage}/{drawingNumber}")
	public ResponseEntity<AssignedPlanDto> getAssignedPlanById(
			@PathVariable String chopCode,
			@PathVariable BigDecimal mileage,
			@PathVariable String drawingNumber) {
		AssignedPlanDto assignedPlan = assignedPlanService.getAssignedPlanById(chopCode, mileage, drawingNumber);
		return ResponseEntity.ok(assignedPlan);
	}

	// Get all AssignedPlans
	@GetMapping
	public ResponseEntity<List<AssignedPlanDto>> getAllAssignedPlans() {
		List<AssignedPlanDto> assignedPlans = assignedPlanService.getAllAssignedPlans();
		return ResponseEntity.ok(assignedPlans);
	}

	// Update AssignedPlan by composite key
	@PutMapping("/{chopCode}/{mileage}/{drawingNumber}")
	public ResponseEntity<AssignedPlanDto> updateAssignedPlan(
			@PathVariable String chopCode,
			@PathVariable BigDecimal mileage,
			@PathVariable String drawingNumber,
			@RequestBody AssignedPlanDto assignedPlanDto) {
		AssignedPlanDto updatedPlan = assignedPlanService.updateAssignedPlan(chopCode, mileage, drawingNumber, assignedPlanDto);
		return ResponseEntity.ok(updatedPlan);
	}

	// Delete AssignedPlan by composite key
	@DeleteMapping("/{chopCode}/{mileage}/{drawingNumber}")
	public ResponseEntity<String> deleteAssignedPlan(
			@PathVariable String chopCode,
			@PathVariable BigDecimal mileage,
			@PathVariable String drawingNumber) {
		assignedPlanService.deleteAssignedPlan(chopCode, mileage, drawingNumber);
		return ResponseEntity.ok("AssignedPlan deleted successfully.");
	}
}