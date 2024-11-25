package com.cpsc471g6.scplan.service.impl;

import com.cpsc471g6.scplan.dto.RegionDto;
import com.cpsc471g6.scplan.entity.Region;
import com.cpsc471g6.scplan.mapper.RegionMapper;
import com.cpsc471g6.scplan.repository.RegionRepository;
import com.cpsc471g6.scplan.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegionServiceImpl implements RegionService {
	private RegionRepository regionRepository;
	@Override
	public RegionDto createRegion(RegionDto regionDto) {
		Region region = RegionMapper.mapToRegion(regionDto);
		Region savedRegion = regionRepository.save(region);
		return RegionMapper.mapToRegionDto(savedRegion);
	}
}
