//package com.cpsc471g6.scplan.mapper;
//
//import com.cpsc471g6.scplan.dto.AsInstallPlanDto;
//import com.cpsc471g6.scplan.entity.AsInstallPlan;
//
//public class AsInstallPlanMapper {
//
//	// Map AsInstallPlan entity to AsInstallPlanDto
//	public static AsInstallPlanDto mapToAsInstallPlanDto(AsInstallPlan asInstallPlan) {
//		if (asInstallPlan == null) {
//			return null;
//		}
//
//		return new AsInstallPlanDto(
//				asInstallPlan.getPlanId().getChopCode(),                  // From PlanId
//				asInstallPlan.getPlanId().getMileage(),                   // From PlanId
//				asInstallPlan.getPlanId().getDrawingNumber(),             // From PlanId
//				asInstallPlan.getProject().getId(),                       // Associated project ID
//				asInstallPlan.getPlanType(),                              // Plan type (Discriminator column)
//				asInstallPlan.isAssignedStatus(),                         // Assigned status (from ArchivePlan)
//				asInstallPlan.getArchiveStatus(),                         // Archive status (from ArchivePlan)
//				DocumentControllerMapper.mapToDocumentControllerDto(asInstallPlan.getDocumentController()), // DocumentController
//				asInstallPlan.getCheckedInDate()                            // Specific to AsInstallPlan
//		);
//	}
//
//	// Map AsInstallPlanDto to AsInstallPlan entity
//	public static AsInstallPlan mapToAsInstallPlan(AsInstallPlanDto asInstallPlanDto) {
//		if (asInstallPlanDto == null) {
//			return null;
//		}
//
//		AsInstallPlan asInstallPlan = new AsInstallPlan();
//		asInstallPlan.getPlanId().setChopCode(asInstallPlanDto.getChopCode());
//		asInstallPlan.getPlanId().setMileage(asInstallPlanDto.getMileage());
//		asInstallPlan.getPlanId().setDrawingNumber(asInstallPlanDto.getDrawingNumber());
//		asInstallPlan.setPlanType(asInstallPlanDto.getPlanType());
//		asInstallPlan.setAssignedStatus(asInstallPlanDto.isAssignedStatus());
//		asInstallPlan.setArchiveStatus(asInstallPlanDto.getArchiveStatus());
//		asInstallPlan.setCheckedInDate(asInstallPlanDto.getCheckInDate());
//
//		// Note: Setting Project and DocumentController entities should be done in the service layer
//		return asInstallPlan;
//	}
//}