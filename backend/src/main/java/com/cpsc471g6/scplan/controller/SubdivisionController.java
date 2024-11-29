package com.cpsc471g6.scplan.controller;

import com.cpsc471g6.scplan.dto.SubdivisionDto;
import com.cpsc471g6.scplan.service.RegionService;
import com.cpsc471g6.scplan.service.SubdivisionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/subdivisions")

public class SubdivisionController {
	private SubdivisionService subdivisionService;

	// Build Add Subdivision REST API
	@PostMapping
	public ResponseEntity<SubdivisionDto> createSubdivision(@PathVariable("regionId") int regionId,
	                                                        @RequestBody SubdivisionDto subdivisionDto) {
		SubdivisionDto savedSubdivision = subdivisionService.createSubdivision(subdivisionDto, regionId);
		return new ResponseEntity<>(savedSubdivision, HttpStatus.CREATED);
	}


	// Build Get Subdivision by Chop Code REST API
	@GetMapping("{chopCode}")
	public ResponseEntity<SubdivisionDto> getSubdivisionById(@PathVariable("regionId") int regionId,
	                                                         @PathVariable("chopCode") String chopCode) {
		SubdivisionDto subdivisionDto = subdivisionService.getSubdivisionByChopCode(regionId, chopCode);
		return ResponseEntity.ok(subdivisionDto);
	}

	// Build Get All Subdivision REST API
	@GetMapping
	public ResponseEntity<List<SubdivisionDto>> getAllSubdivisions(@PathVariable("regionId") int regionId) {
		List<SubdivisionDto> subdivisions = subdivisionService.getAllSubdivisions(regionId);
		return ResponseEntity.ok(subdivisions);
	}

	// Build Update Subdivision REST API
	@PutMapping
	public ResponseEntity<SubdivisionDto> updateSubdivision(@PathVariable("regionId") int regionId,
	                                                        @PathVariable("chopCode") String chopCode,
	                                                        @RequestBody SubdivisionDto updatedSubdivision) {
		SubdivisionDto subdivisionDto = subdivisionService.updateSubdivision(regionId, chopCode, updatedSubdivision);
		return ResponseEntity.ok(subdivisionDto);
	}

	// Build Delete Subdivision REST API
	@DeleteMapping
	public ResponseEntity<String> deleteSubdivision(@PathVariable("regionId") int regionId,
	                                                @PathVariable("chopCode") String chopCode) {
		subdivisionService.deleteSubdivision(regionId, chopCode);
		return ResponseEntity.ok("Subdivision " + chopCode + " deleted successfully.");
	}
}