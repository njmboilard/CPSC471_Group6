package com.cpsc471g6.scplan.mapper;

import com.cpsc471g6.scplan.dto.RegionDto;
import com.cpsc471g6.scplan.entity.Region;

public class RegionMapper {
	public static RegionDto mapToRegionDto (Region region) {
		return new RegionDto(
				region.getId(),
				region.getName()
		);
	}

	public static Region mapToRegion (RegionDto regionDto) {
		return new Region(
				regionDto.getId(),
				regionDto.getName()
		);
	}
}
