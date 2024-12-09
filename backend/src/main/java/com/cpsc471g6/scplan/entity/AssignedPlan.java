package com.cpsc471g6.scplan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assigned_plan")

public class AssignedPlan {
	@EmbeddedId
	private PlanId planId;

	@MapsId
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "chop_code", referencedColumnName = "chop_code"),
			@JoinColumn(name = "mileage", referencedColumnName = "mileage"),
			@JoinColumn(name = "drawing_number", referencedColumnName = "drawing_number")
	})
	private Plan plan;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id", nullable = false)
	private Project project;

	@Column(name = "assigned_status", nullable = false)
	private boolean assignedStatus;
}