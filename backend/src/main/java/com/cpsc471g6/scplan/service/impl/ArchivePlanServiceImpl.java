package com.cpsc471g6.scplan.service.impl;

import com.cpsc471g6.scplan.dto.ArchivePlanDto;
import com.cpsc471g6.scplan.entity.*;
import com.cpsc471g6.scplan.exception.ResourceNotFoundException;
import com.cpsc471g6.scplan.mapper.ArchivePlanMapper;
import com.cpsc471g6.scplan.repository.ArchivePlanRepository;
import com.cpsc471g6.scplan.repository.PlanRepository;
import com.cpsc471g6.scplan.service.ArchivePlanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ArchivePlanServiceImpl implements ArchivePlanService {
	private final PlanRepository planRepository;
	private final ArchivePlanRepository archivePlanRepository;

	@Override
	public ArchivePlanDto createArchivePlan(ArchivePlanDto archivePlanDto) {
		PlanId planId = new PlanId(
				archivePlanDto.getChopCode(),
				archivePlanDto.getMileage(),
				archivePlanDto.getDrawingNumber()
		);

		// Fetch or create the Plan
		Plan plan = planRepository.findById(planId).orElseThrow(
				() -> new ResourceNotFoundException("Plan not found for " + planId)
		);

		// Map to ArchivePlan and set its parent Plan
		ArchivePlan archivePlan = ArchivePlanMapper.mapToArchivePlan(archivePlanDto, plan);

		// Save ArchivePlan
		ArchivePlan savedArchivePlan = archivePlanRepository.save(archivePlan);

		// Return DTO
		return ArchivePlanMapper.mapToArchivePlanDto(savedArchivePlan);
	}

	@Override
	public ArchivePlanDto getArchivePlanById(String chopCode, BigDecimal mileage, String drawingNumber) {
		PlanId planId = new PlanId(chopCode, mileage, drawingNumber);
		ArchivePlan archivePlan = archivePlanRepository.findById(planId).orElseThrow(
				() -> new ResourceNotFoundException("Archive plan not found for " + planId)
		);
		return ArchivePlanMapper.mapToArchivePlanDto(archivePlan);
	}

	@Override
	public List<ArchivePlanDto> getAllArchivePlans(String chopCode, BigDecimal mileage) {
		List<ArchivePlan> archivePlans = archivePlanRepository.findByLocation(chopCode, mileage);
		return archivePlans.stream()
				.map(ArchivePlanMapper::mapToArchivePlanDto)
				.collect(Collectors.toList());
	}

	@Override
	public ArchivePlanDto updateArchivePlan(String chopCode, BigDecimal mileage, String drawingNumber, ArchivePlanDto archivePlanDto) {
		PlanId planId = new PlanId(chopCode, mileage, drawingNumber);
		ArchivePlan existingArchivePlan = archivePlanRepository.findById(planId).orElseThrow(
				() -> new ResourceNotFoundException("Archive plan not found for " + planId)
		);

		// Update fields
		existingArchivePlan.setUploadDate(archivePlanDto.getUploadDate());
		existingArchivePlan.setAssignedStatus(archivePlanDto.isAssignedStatus());
		existingArchivePlan.setArchiveStatus(archivePlanDto.getArchiveStatus());

		ArchivePlan updatedArchivePlan = archivePlanRepository.save(existingArchivePlan);
		return ArchivePlanMapper.mapToArchivePlanDto(updatedArchivePlan);
	}

	@Override
	public void deleteArchivePlan(String chopCode, BigDecimal mileage, String drawingNumber) {
		PlanId planId = new PlanId(chopCode, mileage, drawingNumber);
		ArchivePlan archivePlan = archivePlanRepository.findById(planId).orElseThrow(
				() -> new ResourceNotFoundException("Archive plan not found for " + planId)
		);
		archivePlanRepository.delete(archivePlan);
	}
}