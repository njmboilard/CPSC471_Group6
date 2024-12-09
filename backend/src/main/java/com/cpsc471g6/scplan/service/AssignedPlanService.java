package com.cpsc471g6.scplan.service;

import com.cpsc471g6.scplan.dto.AssignedPlanDto;

import java.math.BigDecimal;
import java.util.List;

public interface AssignedPlanService {
	AssignedPlanDto createAssignedPlan(AssignedPlanDto assignedPlanDto);
	AssignedPlanDto getAssignedPlanById(String chopCode, BigDecimal mileage, String drawingNumber);
	List<AssignedPlanDto> getAllAssignedPlans();
	AssignedPlanDto updateAssignedPlan(String chopCode, BigDecimal mileage, String drawingNumber, AssignedPlanDto assignedPlanDto);
	void deleteAssignedPlan(String chopCode, BigDecimal mileage, String drawingNumber);
}