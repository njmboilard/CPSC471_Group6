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
@Table(name = "as_install_plan")
@DiscriminatorValue("AS_INSTALL") // Discriminator value for AsInstallPlan

public class AsInstallPlan extends AssignedPlan {
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "dc_employee_id", referencedColumnName = "employee_id", nullable = false)
	private DocumentController documentController; // Employee of type DocumentController

	@Column(name = "checked_in_date", nullable = false)
	private LocalDate checkedInDate;
}