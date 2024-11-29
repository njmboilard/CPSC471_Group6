package com.cpsc471g6.scplan.mapper;

import com.cpsc471g6.scplan.dto.RegionDto;
import com.cpsc471g6.scplan.entity.Region;

import java.util.Collections;
import java.util.stream.Collectors;

public class RegionMapper {
	public static RegionDto mapToRegionDto (Region region) {
		return new RegionDto(
				region.getId(),
				region.getName(),
				region.getSubdivisions() != null
					? region.getSubdivisions().stream().map(SubdivisionMapper::mapToSubdivisionDto).collect(Collectors.toList())
					: Collections.emptyList()
		);
	}

	public static Region mapToRegion (RegionDto regionDto) {
		Region region = new Region();
		region.setId(regionDto.getId());
		region.setName(regionDto.getName());
		return region;
	}
}
