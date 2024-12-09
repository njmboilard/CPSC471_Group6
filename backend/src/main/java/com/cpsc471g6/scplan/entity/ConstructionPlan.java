package com.cpsc471g6.scplan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "construction_plan")
@DiscriminatorValue("CONSTRUCTION") // Discriminator value for ConstructionPlan

public class ConstructionPlan extends AssignedPlan {
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "dc_employee_id", referencedColumnName = "employee_id", nullable = false)
	private DocumentController documentController; // Employee of type DocumentController

	@Column(name = "issuance_date", nullable = false)
	private LocalDate issuanceDate;

	@Column(name = "in_service_date", nullable = false)
	private LocalDate inServiceDate;
}