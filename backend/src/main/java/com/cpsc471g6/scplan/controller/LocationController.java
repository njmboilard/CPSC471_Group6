package com.cpsc471g6.scplan.controller;

import com.cpsc471g6.scplan.dto.LocationDto;
import com.cpsc471g6.scplan.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/regions/{regionId}/subdivisions/{chopCode}/locations")
public class LocationController {
	private LocationService locationService;

	// Build Add Location REST API
	@PostMapping
	public ResponseEntity<LocationDto> createLocation(@PathVariable("regionId") int regionId,
	                                                  @PathVariable("chopCode") String chopCode,
	                                                  @RequestBody LocationDto locationDto) {
		LocationDto savedLocation = locationService.createLocation(locationDto, chopCode);
		return new ResponseEntity<>(savedLocation, HttpStatus.CREATED);
	}

	// Build Get Location by Chop Code and Mileage REST API
	@GetMapping("{mileage}")
	public ResponseEntity<LocationDto> getLocationById(@PathVariable("chopCode") String chopCode,
	                                                   @PathVariable("mileage") BigDecimal mileage) {
		LocationDto locationDto = locationService.getLocationById(chopCode, mileage);
		return ResponseEntity.ok(locationDto);
	}

	// Build Get All Locations REST API
	@GetMapping
	public ResponseEntity<List<LocationDto>> getAllLocations(@PathVariable("chopCode") String chopCode) {
		List<LocationDto> locations = locationService.getAllLocations(chopCode);
		return ResponseEntity.ok(locations);
	}

	@PutMapping("{mileage}")
	public ResponseEntity<LocationDto> updateLocation(@PathVariable("chopCode") String oldChopCode,
	                                                  @PathVariable("mileage") BigDecimal oldMileage,
	                                                  @RequestBody LocationDto updatedLocation) {

		// Call service to update the location
		LocationDto locationDto = locationService.updateLocation(oldChopCode, oldMileage, updatedLocation);
		return ResponseEntity.ok(locationDto);
	}

	// Build Delete Location REST API
	@DeleteMapping("{mileage}")
	public ResponseEntity<String> deleteLocation(@PathVariable("chopCode") String chopCode,
	                                                  @PathVariable("mileage") BigDecimal mileage) {
		locationService.deleteLocation(chopCode, mileage);
		return ResponseEntity.ok("Location " + chopCode + " " + mileage + " deleted successfully");
	}
}
