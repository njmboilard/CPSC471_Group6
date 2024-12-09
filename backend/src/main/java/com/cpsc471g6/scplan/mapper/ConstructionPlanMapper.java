//package com.cpsc471g6.scplan.mapper;
//
//import com.cpsc471g6.scplan.dto.ConstructionPlanDto;
//import com.cpsc471g6.scplan.entity.ConstructionPlan;
//
//public class ConstructionPlanMapper {
//
//	// Map ConstructionPlan entity to ConstructionPlanDto
//	public static ConstructionPlanDto mapToConstructionPlanDto(ConstructionPlan constructionPlan) {
//		if (constructionPlan == null) {
//			return null;
//		}
//
//		return new ConstructionPlanDto(
//				constructionPlan.getPlanId().getChopCode(),                  // From PlanId
//				constructionPlan.getPlanId().getMileage(),                   // From PlanId
//				constructionPlan.getPlanId().getDrawingNumber(),             // From PlanId
//				constructionPlan.getProject().getId(),                       // Associated project ID
//				constructionPlan.getPlanType(),                              // Plan type (Discriminator column)
//				constructionPlan.isAssignedStatus(),                         // Assigned status (from ArchivePlan)
//				constructionPlan.getArchiveStatus(),                         // Archive status (from ArchivePlan)
//				DocumentControllerMapper.mapToDocumentControllerDto(constructionPlan.getDocumentController()), // DocumentController
//				constructionPlan.getIssuanceDate(),                          // Specific to ConstructionPlan
//				constructionPlan.getInServiceDate()                          // Specific to ConstructionPlan
//		);
//	}
//
//	// Map ConstructionPlanDto to ConstructionPlan entity
//	public static ConstructionPlan mapToConstructionPlan(ConstructionPlanDto constructionPlanDto) {
//		if (constructionPlanDto == null) {
//			return null;
//		}
//
//		ConstructionPlan constructionPlan = new ConstructionPlan();
//		constructionPlan.getPlanId().setChopCode(constructionPlanDto.getChopCode());
//		constructionPlan.getPlanId().setMileage(constructionPlanDto.getMileage());
//		constructionPlan.getPlanId().setDrawingNumber(constructionPlanDto.getDrawingNumber());
//		constructionPlan.setPlanType(constructionPlanDto.getPlanType());
//		constructionPlan.setAssignedStatus(constructionPlanDto.isAssignedStatus());
//		constructionPlan.setArchiveStatus(constructionPlanDto.getArchiveStatus());
//		constructionPlan.setIssuanceDate(constructionPlanDto.getIssuanceDate());
//		constructionPlan.setInServiceDate(constructionPlanDto.getInServiceDate());
//
//		// Note: Setting Project and DocumentController entities should be done in the service layer
//		return constructionPlan;
//	}
//}