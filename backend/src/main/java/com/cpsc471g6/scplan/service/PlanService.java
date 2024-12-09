package com.cpsc471g6.scplan.service;

import com.cpsc471g6.scplan.dto.LocationDto;
import com.cpsc471g6.scplan.dto.PlanDto;

import java.math.BigDecimal;
import java.util.List;

public interface PlanService {
	PlanDto createPlan(PlanDto planDto, String chopCode, BigDecimal mileage);

	PlanDto getPlanById(String chopCode, BigDecimal mileage, String drawingNumber);

	List<PlanDto> getAllPlans(String chopCode, BigDecimal mileage);

	PlanDto updatePlan(String chopCode, BigDecimal mileage, String drawingNumber, PlanDto planDto);

	void deletePlan(String chopCode, BigDecimal mileage, String drawingNumber);
}