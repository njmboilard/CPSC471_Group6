package com.cpsc471g6.scplan.mapper;

import com.cpsc471g6.scplan.dto.AssignedPlanDto;
import com.cpsc471g6.scplan.entity.AssignedPlan;
import com.cpsc471g6.scplan.entity.PlanId;

public class AssignedPlanMapper {

	// Map AssignedPlan entity to AssignedPlanDto
	public static AssignedPlanDto mapToAssignedPlanDto(AssignedPlan assignedPlan) {
		return new AssignedPlanDto(
				assignedPlan.getPlanId().getChopCode(),              // Extract chopCode from PlanId
				assignedPlan.getPlanId().getMileage(),               // Extract mileage from PlanId
				assignedPlan.getPlanId().getDrawingNumber(),         // Extract drawingNumber from PlanId
				assignedPlan.getProject() != null ? assignedPlan.getProject().getId() : null, // Project ID
				assignedPlan.isAssignedStatus()                     // Assigned status
		);
	}

	// Map AssignedPlanDto to AssignedPlan entity
	public static AssignedPlan mapToAssignedPlan(AssignedPlanDto assignedPlanDto) {
		AssignedPlan assignedPlan = new AssignedPlan();

		// Set PlanId details
		assignedPlan.setPlanId(new PlanId(
				assignedPlanDto.getChopCode(),
				assignedPlanDto.getMileage(),
				assignedPlanDto.getDrawingNumber()
		));

		// Set other fields
		assignedPlan.setAssignedStatus(assignedPlanDto.isAssignedStatus());  // Assigned status

		// Project relationship mapping must be handled in the service layer
		return assignedPlan;
	}
}