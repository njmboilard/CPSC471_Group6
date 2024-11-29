package com.cpsc471g6.scplan.service;

import com.cpsc471g6.scplan.dto.SubdivisionDto;

import java.util.List;

public interface SubdivisionService {
	SubdivisionDto createSubdivision(SubdivisionDto subdivisionDto, int regionId);

	SubdivisionDto getSubdivisionByChopCode(int regionId, String chopCope);

	List<SubdivisionDto> getAllSubdivisions(int regionId);

	SubdivisionDto updateSubdivision(int regionId, String chopCope, SubdivisionDto subdivisionDto);

	void deleteSubdivision(int regionId, String chopCope);
}