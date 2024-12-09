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
@Table(name = "archive_plan")

public class ArchivePlan {
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

	@Column(name = "upload_date", nullable = false)
	private LocalDate uploadDate;

	@Column(name = "archive_status", nullable = false)
	private String archiveStatus;

	@Column(name = "assigned_status", nullable = false)
	private boolean assignedStatus;
}