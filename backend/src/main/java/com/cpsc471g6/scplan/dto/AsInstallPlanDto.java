//package com.cpsc471g6.scplan.dto;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//
//public class AsInstallPlanDto {
//	private String chopCode;                            // From PlanId
//	private BigDecimal mileage;                         // From PlanId
//	private String drawingNumber;                       // From PlanId
//	private int projectId;                              // Foreign key to Project
//	private String planType;                            // Discriminator column
//	private boolean assignedStatus;                     // Indicates if the plan is assigned (from ArchivePlan)
//	private String archiveStatus;                       // Archive status (from ArchivePlan)
//	private DocumentControllerDto documentController;   // DocumentController details
//	private LocalDate checkInDate;                      // Specific to AsInstallPlan
//}