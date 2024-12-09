package com.cpsc471g6.scplan.mapper;

import com.cpsc471g6.scplan.dto.PlanDto;
import com.cpsc471g6.scplan.entity.Location;
import com.cpsc471g6.scplan.entity.Plan;
import com.cpsc471g6.scplan.entity.PlanId;

public class PlanMapper {
	public static PlanDto mapToPlanDto(Plan plan) {
		return new PlanDto(
				plan.getPlanId().getChopCode(),
				plan.getPlanId().getMileage(),
				plan.getPlanId().getDrawingNumber()
		);
	}

	public static Plan mapToPlan(PlanDto planDto, Location location) {
		Plan plan = new Plan();
		PlanId planId = new PlanId(planDto.getChopCode(), planDto.getMileage(), planDto.getDrawingNumber());
		plan.setPlanId(planId);
		plan.setLocation(location);
		return plan;
	}
}
