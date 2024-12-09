package com.cpsc471g6.scplan.controller;

import com.cpsc471g6.scplan.dto.PlanDto;
import com.cpsc471g6.scplan.service.PlanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/regions/{regionId}/subdivisions/{chopCode}/locations/{mileage}/plans")

public class PlanController {
	private PlanService planService;

	// Build Add Plan REST API
	@PostMapping
	public ResponseEntity<PlanDto> createPlan(@PathVariable String regionId,
	                                          @PathVariable("chopCode") String chopCode,
	                                          @PathVariable("mileage") BigDecimal mileage,
	                                          @RequestBody PlanDto planDto) {
		PlanDto savedPlan = planService.createPlan(planDto, chopCode, mileage);
		return new ResponseEntity<>(savedPlan, HttpStatus.CREATED);
	}

	// Build Get Plan by Drawing Number REST API
	@GetMapping("{drawingNumber}")
	public ResponseEntity<PlanDto> getPlanById(@PathVariable("chopCode") String chopCode,
	                                           @PathVariable("mileage") BigDecimal mileage,
	                                           @PathVariable("drawingNumber") String drawingNumber) {
		PlanDto planDto = planService.getPlanById(chopCode, mileage, drawingNumber);
		return ResponseEntity.ok(planDto);
	}

	// Build Get All Plans REST API
	@GetMapping
	public ResponseEntity<List<PlanDto>> getAllPlans(@PathVariable("chopCode") String chopCode,
	                                           @PathVariable("mileage") BigDecimal mileage) {
		List<PlanDto> plans = planService.getAllPlans(chopCode, mileage);
		return ResponseEntity.ok(plans);
	}

	// Build Update Plan REST API
	@PutMapping("{oldDrawingNumber}")
	public ResponseEntity<PlanDto> updatePlan(@PathVariable("chopCode") String oldChopCode,
	                                          @PathVariable("mileage") BigDecimal oldMileage,
	                                          @PathVariable("oldDrawingNumber") String oldDrawingNumber,
	                                          @RequestBody PlanDto planDto) {
		PlanDto updatedPlan = planService.updatePlan(oldChopCode, oldMileage, oldDrawingNumber, planDto);
		return ResponseEntity.ok(updatedPlan);
	}

	// Build Delete Plan REST API
	@DeleteMapping("{drawingNumber}")
	public ResponseEntity<String> deletePlan(@PathVariable("chopCode") String chopCode,
	                                         @PathVariable("mileage") BigDecimal mileage,
	                                         @PathVariable("drawingNumber") String drawingNumber) {
		planService.deletePlan(chopCode, mileage, drawingNumber);
		return ResponseEntity.ok("Plan set " + drawingNumber + " for " + chopCode + " " + mileage + " deleted successfully.");
	}
}
