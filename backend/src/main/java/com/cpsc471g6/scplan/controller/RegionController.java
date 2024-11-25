package com.cpsc471g6.scplan.controller;

import com.cpsc471g6.scplan.dto.RegionDto;
import com.cpsc471g6.scplan.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
