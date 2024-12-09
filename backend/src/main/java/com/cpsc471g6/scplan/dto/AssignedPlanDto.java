package com.cpsc471g6.scplan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssignedPlanDto {
	private String chopCode;         // Chop Code of the Plan
	private BigDecimal mileage;      // Mileage of the Plan
	private String drawingNumber;    // Drawing Number of the Plan
	private Integer projectId;       // Associated Project ID
	private boolean assignedStatus;  // Assigned status
}