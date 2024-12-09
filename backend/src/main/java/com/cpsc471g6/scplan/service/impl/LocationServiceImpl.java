package com.cpsc471g6.scplan.service.impl;

import com.cpsc471g6.scplan.dto.LocationDto;
import com.cpsc471g6.scplan.entity.Location;
import com.cpsc471g6.scplan.entity.LocationId;
import com.cpsc471g6.scplan.entity.Subdivision;
import com.cpsc471g6.scplan.exception.ResourceNotFoundException;
import com.cpsc471g6.scplan.mapper.LocationMapper;
import com.cpsc471g6.scplan.repository.LocationRepository;
import com.cpsc471g6.scplan.repository.SubdivisionRepository;
import com.cpsc471g6.scplan.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class LocationServiceImpl implements LocationService {
	private LocationRepository locationRepository;
	private SubdivisionRepository subdivisionRepository;

	@Override
	public LocationDto createLocation(LocationDto locationDto, String chopCode) {
		Subdivision subdivision = subdivisionRepository.findById(chopCode).orElseThrow(
				() -> new ResourceNotFoundException("Subdivision " + chopCode + " not found.")
		);
		Location location = LocationMapper.mapToLocation(locationDto, subdivision);
		Location savedLocation = locationRepository.save(location);
		return LocationMapper.mapToLocationDto(savedLocation);
	}

	@Override
	public LocationDto getLocationById(String chopCode, BigDecimal mileage) {
		LocationId locationId = new LocationId(chopCode, mileage);
		Location location = locationRepository.findById(locationId).orElseThrow(
				() -> new ResourceNotFoundException("Location " + chopCode + " " + mileage + " not found.")
		);
		return LocationMapper.mapToLocationDto(location);
	}

	@Override
	public List<LocationDto> getAllLocations(String chopCode) {
		Subdivision subdivision = subdivisionRepository.findById(chopCode).orElseThrow(
				() -> new ResourceNotFoundException("Subdivision " + chopCode + " not found.")
		);
		List<Location> locations = subdivision.getLocations();
		return locations.stream().map(LocationMapper::mapToLocationDto).collect(Collectors.toList());
	}

	@Override
	public LocationDto updateLocation(String oldChopCode, BigDecimal oldMileage, LocationDto locationDto) {
		LocationId oldLocationId = new LocationId(oldChopCode, oldMileage);

		// Fetch the existing location
		Location existingLocation = locationRepository.findById(oldLocationId).orElseThrow(
				() -> new ResourceNotFoundException("Location with chopCode " + oldChopCode + " and mileage " + oldMileage + " not found.")
		);

		// Check if chopCode or mileage is changing
		boolean isChopCodeChanging = !oldChopCode.equals(locationDto.getChopCode());
		boolean isMileageChanging = !oldMileage.equals(locationDto.getMileage());

		if (isChopCodeChanging || isMileageChanging) {
			// Validate that the new chopCode and mileage are available
			LocationId newLocationId = new LocationId(locationDto.getChopCode(), locationDto.getMileage());
			if (locationRepository.existsById(newLocationId)) {
				throw new IllegalArgumentException("A location with the specified chopCode and mileage already exists.");
			}

			// Fetch the new Subdivision for the updated chopCode
			Subdivision newSubdivision = subdivisionRepository.findById(locationDto.getChopCode()).orElseThrow(
					() -> new ResourceNotFoundException("Subdivision " + locationDto.getChopCode() + " not found.")
			);

			// Update existing location with new subdivision and key values
			existingLocation.setId(newLocationId);
			existingLocation.setSubdivision(newSubdivision);
		}

		// Update the non-key fields
		existingLocation.setLocationType(locationDto.getLocationType());
		existingLocation.setLocationName(locationDto.getLocationName());

		// Save the updated location
		Location updatedLocation = locationRepository.save(existingLocation);

		return LocationMapper.mapToLocationDto(updatedLocation);
	}

	@Override
	public void deleteLocation(String chopCode, BigDecimal mileage) {
		LocationId locationId = new LocationId(chopCode, mileage);
		Location location = locationRepository.findById(locationId).orElseThrow(
				() -> new ResourceNotFoundException("Location " + chopCode + " " + mileage + " not found.")
		);
		locationRepository.deleteById(locationId);
	}
}
