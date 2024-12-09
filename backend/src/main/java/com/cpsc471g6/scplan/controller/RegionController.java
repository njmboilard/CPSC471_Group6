package com.cpsc471g6.scplan.controller;

import com.cpsc471g6.scplan.dto.RegionDto;
import com.cpsc471g6.scplan.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/regions")
public class RegionController {
	private RegionService regionService;

	// Build Add Region REST API
	@PostMapping
	public ResponseEntity<RegionDto> createRegion(@RequestBody RegionDto regionDto) {
		RegionDto savedRegion = regionService.createRegion(regionDto);
		return new ResponseEntity<>(savedRegion, HttpStatus.CREATED);
	}

	// Build Get Region REST API
	@GetMapping("{id}")
	public ResponseEntity<RegionDto> getRegionById(@PathVariable("id") int regionId) {
		RegionDto regionDto = regionService.getRegionById(regionId);
		return ResponseEntity.ok(regionDto);
	}

	// Build Get All Region REST API
	@GetMapping
	public ResponseEntity<List<RegionDto>> getAllRegions() {
		List<RegionDto> regions = regionService.getAllRegions();
		return ResponseEntity.ok(regions);
	}

	// Build Update Region REST API
	@PutMapping("{id}")
	public ResponseEntity<RegionDto> updateRegion(@PathVariable("id") int regionId,
	                                              @RequestBody RegionDto updatedRegion) {
		RegionDto regionDto = regionService.updateRegion(regionId, updatedRegion);
		return ResponseEntity.ok(regionDto);
	}

	// Build Delete Region REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteRegion(@PathVariable("id") int regionId) {
		regionService.deleteRegion(regionId);
		return ResponseEntity.ok("Region " + regionId + " deleted successfully.");
	}
}
