package com.cpsc471g6.scplan.mapper;

import com.cpsc471g6.scplan.dto.SubdivisionDto;
import com.cpsc471g6.scplan.entity.Region;
import com.cpsc471g6.scplan.entity.Subdivision;

public class SubdivisionMapper {
	public static SubdivisionDto mapToSubdivisionDto(Subdivision subdivision) {
		return new SubdivisionDto(
				subdivision.getChopCode(),
				subdivision.getName(),
				subdivision.getRegion().getId()
		);
	}

	public static Subdivision mapToSubdivision(SubdivisionDto subdivisionDto, Region region) {
				return new Subdivision(
				subdivisionDto.getChopCode(),
				subdivisionDto.getName(),
				region
		);
	}
}