package com.cpsc471g6.scplan.controller;

import com.cpsc471g6.scplan.dto.ArchivePlanDto;
import com.cpsc471g6.scplan.service.ArchivePlanService;
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
public class ArchivePlanController {

	private final ArchivePlanService archivePlanService;

	/**
	 * Create an Archive Plan
	 */
	@PostMapping("/{drawingNumber}/archive")
	public ResponseEntity<ArchivePlanDto> createArchivePlan(
			@PathVariable String chopCode,
			@PathVariable BigDecimal mileage,
			@PathVariable String drawingNumber,
			@RequestBody ArchivePlanDto archivePlanDto) {
		archivePlanDto.setChopCode(chopCode);
		archivePlanDto.setMileage(mileage);
		archivePlanDto.setDrawingNumber(drawingNumber);

		ArchivePlanDto savedPlan = archivePlanService.createArchivePlan(archivePlanDto);
		return new ResponseEntity<>(savedPlan, HttpStatus.CREATED);
	}

	/**
	 * Get an Archive Plan by ID
	 */
	@GetMapping("/{drawingNumber}/archive")
	public ResponseEntity<ArchivePlanDto> getArchivePlanById(
			@PathVariable String chopCode,
			@PathVariable BigDecimal mileage,
			@PathVariable String drawingNumber) {

		// Fetch the Archive Plan
		ArchivePlanDto archivePlan = archivePlanService.getArchivePlanById(chopCode, mileage, drawingNumber);

		// Return the fetched Archive Plan
		return ResponseEntity.ok(archivePlan);
	}

	/**
	 * Get All Archive Plans for a specific location
	 */
	@GetMapping("/archive")
	public ResponseEntity<List<ArchivePlanDto>> getAllArchivePlans(
			@PathVariable String chopCode,
			@PathVariable BigDecimal mileage) {

		// Fetch all Archive Plans for the specified location
		List<ArchivePlanDto> archivePlans = archivePlanService.getAllArchivePlans(chopCode, mileage);

		// Return the list of Archive Plans
		return ResponseEntity.ok(archivePlans);
	}

	/**
	 * Update an Archive Plan by ID
	 */
	@PutMapping("/{drawingNumber}/archive")
	public ResponseEntity<ArchivePlanDto> updateArchivePlan(
			@PathVariable String chopCode,
			@PathVariable BigDecimal mileage,
			@PathVariable String drawingNumber,
			@RequestBody ArchivePlanDto archivePlanDto) {

		// Validate input and set necessary fields in DTO
		archivePlanDto.setChopCode(chopCode);
		archivePlanDto.setMileage(mileage);
		archivePlanDto.setDrawingNumber(drawingNumber);

		// Call the service to update the Archive Plan
		ArchivePlanDto updatedPlan = archivePlanService.updateArchivePlan(chopCode, mileage, drawingNumber, archivePlanDto);

		// Return the updated Archive Plan
		return ResponseEntity.ok(updatedPlan);
	}

	/**
	 * Delete an Archive Plan by ID
	 */
	@DeleteMapping("/{drawingNumber}/archive")
	public ResponseEntity<String> deleteArchivePlan(
			@PathVariable String chopCode,
			@PathVariable BigDecimal mileage,
			@PathVariable String drawingNumber) {

		// Call the service to delete the Archive Plan
		archivePlanService.deleteArchivePlan(chopCode, mileage, drawingNumber);

		// Return a success message
		return new ResponseEntity<>("Archive plan deleted successfully", HttpStatus.OK);
	}
}