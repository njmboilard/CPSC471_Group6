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
@Table(name = "works_on")

public class WorksOn {
	@EmbeddedId
	private WorksOnId id; // Composite primary key

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("projectId") // Maps this field to the projectId in the composite key
	@JoinColumn(name = "project_id", nullable = false)
	private Project project;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("employeeId") // Maps this field to the employeeId in the composite key
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;
}