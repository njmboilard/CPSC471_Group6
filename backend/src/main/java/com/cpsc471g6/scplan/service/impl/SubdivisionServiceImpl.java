package com.cpsc471g6.scplan.service.impl;

import com.cpsc471g6.scplan.dto.SubdivisionDto;
import com.cpsc471g6.scplan.entity.Region;
import com.cpsc471g6.scplan.entity.Subdivision;
import com.cpsc471g6.scplan.exception.ResourceNotFoundException;
import com.cpsc471g6.scplan.mapper.SubdivisionMapper;
import com.cpsc471g6.scplan.repository.RegionRepository;
import com.cpsc471g6.scplan.repository.SubdivisionRepository;
import com.cpsc471g6.scplan.service.SubdivisionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class SubdivisionServiceImpl implements SubdivisionService {
	private SubdivisionRepository subdivisionRepository;
	private RegionRepository regionRepository;

	@Override
	public SubdivisionDto createSubdivision(SubdivisionDto subdivisionDto, int regionId) {
		Region region = regionRepository.findById(regionId).orElseThrow(
				() -> new ResourceNotFoundException("Region " + regionId + " not found.")
		);
		Subdivision subdivision = SubdivisionMapper.mapToSubdivision(subdivisionDto, region);
		Subdivision savedSubdivision = subdivisionRepository.save(subdivision);
		return SubdivisionMapper.mapToSubdivisionDto(savedSubdivision);
	}

	@Override
	public SubdivisionDto getSubdivisionByChopCode(int regionId, String chopCope) {
		Region region = regionRepository.findById(regionId).orElseThrow(() ->
				new ResourceNotFoundException("Region " + regionId + " not found."));
		Subdivision subdivision = subdivisionRepository.findById(chopCope).orElseThrow(() ->
				new ResourceNotFoundException("Subdivision " + chopCope + " not found."));
		if (subdivision.getRegion().getId() != (region.getId())) {
			throw new ResourceNotFoundException("Subdivision " + chopCope + " does not belong to region " + region.getId() + ".");
		}
		return SubdivisionMapper.mapToSubdivisionDto(subdivision);
	}

	@Override
	public List<SubdivisionDto> getAllSubdivisions(int regionId) {
		Region region = regionRepository.findById(regionId).orElseThrow(() ->
				new ResourceNotFoundException("Region " + regionId + " not found."));
		List<Subdivision> subdivisions = region.getSubdivisions();
		return subdivisions.stream().map(SubdivisionMapper::mapToSubdivisionDto).collect(Collectors.toList());
	}

	@Override
	public SubdivisionDto updateSubdivision(int regionId, String chopCope, SubdivisionDto subdivisionDto) {
		Region region = regionRepository.findById(regionId).orElseThrow(() ->
				new ResourceNotFoundException("Region " + regionId + " not found."));
		Subdivision subdivision = subdivisionRepository.findById(chopCope).orElseThrow(() ->
				new ResourceNotFoundException("Subdivision " + chopCope + " not found."));
		if (subdivision.getRegion().getId() != (region.getId())) {
			throw new ResourceNotFoundException("Subdivision " + chopCope + " does not belong to region " + region.getId() + ".");
		}
		subdivision.setName(subdivisionDto.getName());
		Subdivision updatedSubdivisionObj = subdivisionRepository.save(subdivision);
		return SubdivisionMapper.mapToSubdivisionDto(updatedSubdivisionObj);
	}

	@Override
	public void deleteSubdivision(int regionId, String chopCope) {
		Region region = regionRepository.findById(regionId).orElseThrow(() ->
				new ResourceNotFoundException("Region " + regionId + " not found."));
		Subdivision subdivision = subdivisionRepository.findById(chopCope).orElseThrow(() ->
				new ResourceNotFoundException("Subdivision " + chopCope + " not found."));
		if (subdivision.getRegion().getId() != (region.getId())) {
			throw new ResourceNotFoundException("Subdivision " + chopCope + " does not belong to region " + region.getId() + ".");
		}
		subdivisionRepository.deleteById(chopCope);

	}
}