package com.cpsc471g6.scplan.mapper;

import com.cpsc471g6.scplan.dto.LocationDto;
import com.cpsc471g6.scplan.entity.Location;
import com.cpsc471g6.scplan.entity.LocationId;
import com.cpsc471g6.scplan.entity.Subdivision;

import java.util.Collections;
import java.util.stream.Collectors;

public class LocationMapper {
	public static LocationDto mapToLocationDto(Location location) {
		return new LocationDto(
				location.getId().getChopCode(),
				location.getId().getMileage(),
				location.getLocationType(),
				location.getLocationName(),
				location.getPlans() != null
					? location.getPlans().stream().map(PlanMapper::mapToPlanDto).collect(Collectors.toList())
					: Collections.emptyList()
		);
	}

	public static Location mapToLocation(LocationDto locationDto, Subdivision subdivision) {
		Location location = new Location();
		// Create a new LocationId from LocationDto attributes
		LocationId locationId = new LocationId(locationDto.getChopCode(), locationDto.getMileage());
		location.setId(locationId); // Set the composite key
		location.setSubdivision(subdivision); // Set the subdivision entity
		location.setLocationType(locationDto.getLocationType());
		location.setLocationName(locationDto.getLocationName());
		return location;
	}
}