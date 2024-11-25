package com.cpsc471g6.scplan.service;

import com.cpsc471g6.scplan.dto.RegionDto;

import java.util.List;

public interface RegionService {
	RegionDto createRegion(RegionDto regionDto);

	RegionDto getRegionById(int id);

	List<RegionDto> getAllRegions();

	RegionDto updateRegion(int regionId, RegionDto updatedRegion);

	void deleteRegion(int regionId);
}
