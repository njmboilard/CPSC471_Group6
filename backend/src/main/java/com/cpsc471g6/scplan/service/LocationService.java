package com.cpsc471g6.scplan.service;

import com.cpsc471g6.scplan.dto.LocationDto;

import java.math.BigDecimal;
import java.util.List;

public interface LocationService {
	LocationDto createLocation(LocationDto locationDto, String chopCode);

	LocationDto getLocationById(String chopCode, BigDecimal mileage);

	List<LocationDto> getAllLocations(String chopCode);

	LocationDto updateLocation(String chopCode, BigDecimal mileage, LocationDto locationDto);

	void deleteLocation(String chopCode, BigDecimal mileage);
}