package com.cpsc471g6.scplan.mapper;

import com.cpsc471g6.scplan.dto.ArchivePlanDto;
import com.cpsc471g6.scplan.entity.ArchivePlan;
import com.cpsc471g6.scplan.entity.Plan;

public class ArchivePlanMapper {

	public static ArchivePlanDto mapToArchivePlanDto(ArchivePlan archivePlan) {
		Plan plan = archivePlan.getPlan(); // Retrieve parent Plan

		return new ArchivePlanDto(
				plan.getPlanId().getChopCode(),
				plan.getPlanId().getMileage(),
				plan.getPlanId().getDrawingNumber(),
				archivePlan.getUploadDate(),
				archivePlan.isAssignedStatus(),
				archivePlan.getArchiveStatus()
		);
	}

	public static ArchivePlan mapToArchivePlan(ArchivePlanDto archivePlanDto, Plan plan) {
		ArchivePlan archivePlan = new ArchivePlan();
		archivePlan.setPlanId(plan.getPlanId());
		archivePlan.setPlan(plan);
		archivePlan.setUploadDate(archivePlanDto.getUploadDate());
		archivePlan.setAssignedStatus(archivePlanDto.isAssignedStatus());
		archivePlan.setArchiveStatus(archivePlanDto.getArchiveStatus());

		return archivePlan;
	}
}