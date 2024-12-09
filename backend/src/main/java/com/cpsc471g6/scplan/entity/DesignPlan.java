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
@Table(name = "design_plan")
@DiscriminatorValue("DESIGN") // Discriminator value for DesignPlan

public class DesignPlan extends AssignedPlan {
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "dc_employee_id", referencedColumnName = "employee_id", nullable = false)
	private DocumentController documentController; // Employee of type DocumentController

	@Column(name = "check_out_date", nullable = false)
	private LocalDate checkOutDate;
}