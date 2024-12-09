package com.cpsc471g6.scplan.mapper;

import com.cpsc471g6.scplan.dto.SubdivisionDto;
import com.cpsc471g6.scplan.entity.Region;
import com.cpsc471g6.scplan.entity.Subdivision;

import java.util.Collections;
import java.util.stream.Collectors;

public class SubdivisionMapper {
	public static SubdivisionDto mapToSubdivisionDto(Subdivision subdivision) {
		return new SubdivisionDto(
				subdivision.getChopCode(),
				subdivision.getName(),
				subdivision.getRegion().getId(),
				subdivision.getLocations() != null
						? subdivision.getLocations().stream().map(LocationMapper::mapToLocationDto).collect(Collectors.toList())
						: Collections.emptyList()
		);
	}

	public static Subdivision mapToSubdivision(SubdivisionDto subdivisionDto, Region region) {
		Subdivision subdivision = new Subdivision();
		subdivision.setChopCode(subdivisionDto.getChopCode());
		subdivision.setName(subdivisionDto.getName());
		subdivision.setRegion(region);
		return subdivision;
	}
}