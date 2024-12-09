package com.cpsc471g6.scplan.service;

import com.cpsc471g6.scplan.dto.ArchivePlanDto;

import java.math.BigDecimal;
import java.util.List;

public interface ArchivePlanService {
	ArchivePlanDto createArchivePlan(ArchivePlanDto archivePlanDto);

	ArchivePlanDto getArchivePlanById(String chopCode, BigDecimal mileage, String drawingNumber);

	List<ArchivePlanDto> getAllArchivePlans(String chopCode, BigDecimal mileage);

	ArchivePlanDto updateArchivePlan(String chopCode, BigDecimal mileage, String drawingNumber, ArchivePlanDto archivePlanDto);

	void deleteArchivePlan(String chopCode, BigDecimal mileage, String drawingNumber);
}