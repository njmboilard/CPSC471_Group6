//package com.cpsc471g6.scplan.mapper;
//
//import com.cpsc471g6.scplan.dto.DesignPlanDto;
//import com.cpsc471g6.scplan.entity.DesignPlan;
//
//public class DesignPlanMapper {
//
//	// Map DesignPlan entity to DesignPlanDto
//	public static DesignPlanDto mapToDesignPlanDto(DesignPlan designPlan) {
//		if (designPlan == null) {
//			return null;
//		}
//
//		return new DesignPlanDto(
//				designPlan.getPlanId().getChopCode(),                  // From PlanId
//				designPlan.getPlanId().getMileage(),                   // From PlanId
//				designPlan.getPlanId().getDrawingNumber(),             // From PlanId
//				designPlan.getProject().getId(),                       // Associated project ID
//				designPlan.getPlanType(),                              // Plan type (Discriminator column)
//				designPlan.isAssignedStatus(),                         // Assigned status (from ArchivePlan)
//				designPlan.getArchiveStatus(),                         // Archive status (from ArchivePlan)
//				DocumentControllerMapper.mapToDocumentControllerDto(designPlan.getDocumentController()), // DocumentController
//				designPlan.getCheckOutDate()                           // Specific to DesignPlan
//		);
//	}
//
//	// Map DesignPlanDto to DesignPlan entity
//	public static DesignPlan mapToDesignPlan(DesignPlanDto designPlanDto) {
//		if (designPlanDto == null) {
//			return null;
//		}
//
//		DesignPlan designPlan = new DesignPlan();
//		designPlan.getPlanId().setChopCode(designPlanDto.getChopCode());
//		designPlan.getPlanId().setMileage(designPlanDto.getMileage());
//		designPlan.getPlanId().setDrawingNumber(designPlanDto.getDrawingNumber());
//		designPlan.setPlanType(designPlanDto.getPlanType());
//		designPlan.setAssignedStatus(designPlanDto.isAssignedStatus());
//		designPlan.setArchiveStatus(designPlanDto.getArchiveStatus());
//		designPlan.setCheckOutDate(designPlanDto.getCheckOutDate());
//
//		// Note: Setting the Project and DocumentController entities must be handled in the service layer
//		return designPlan;
//	}
//}