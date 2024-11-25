package com.cpsc471g6.scplan.service.impl;

import com.cpsc471g6.scplan.dto.RegionDto;
import com.cpsc471g6.scplan.entity.Region;
import com.cpsc471g6.scplan.exception.ResourceNotFoundException;
import com.cpsc471g6.scplan.mapper.RegionMapper;
import com.cpsc471g6.scplan.repository.RegionRepository;
import com.cpsc471g6.scplan.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

	@Override
	public RegionDto getRegionById(int regionId) {
		Region region = regionRepository.findById(regionId).orElseThrow(() ->
				new ResourceNotFoundException("Region " + regionId + " not found."));
		return RegionMapper.mapToRegionDto(region);
	}

	@Override
	public List<RegionDto> getAllRegions() {
		List<Region> regions = regionRepository.findAll();
		return regions.stream().map((region) ->
				RegionMapper.mapToRegionDto(region)).collect(Collectors.toList());
	}

	@Override
	public RegionDto updateRegion(int regionId, RegionDto updatedRegion) {
		Region region = regionRepository.findById(regionId).orElseThrow(
				() -> new ResourceNotFoundException("Region " + regionId + " not found.")
		);

		region.setName(updatedRegion.getName());

		Region updatedRegionObj = regionRepository.save(region);
		return RegionMapper.mapToRegionDto(updatedRegionObj);
	}

	@Override
	public void deleteRegion(int regionId) {
		Region region = regionRepository.findById(regionId).orElseThrow(
				() -> new ResourceNotFoundException("Region " + regionId + " not found.")
		);

		regionRepository.deleteById(regionId);
	}

}
