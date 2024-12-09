package com.cpsc471g6.scplan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project")

public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "year", nullable = false)
	private int year;

	@Column(name = "project_name", nullable = false)
	private String projectName;

	@Column(name = "project_status", nullable = false)
	private String projectStatus;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "design_lead_id", referencedColumnName = "employee_id", nullable = false)
	private InHouseDesigner designLead;

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AssignedPlan> assignedPlans = new ArrayList<>();

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Issues> issues = new ArrayList<>();

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<WorksOn> worksOnList = new ArrayList<>();

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ContractedOn> contractedOnList = new ArrayList<>();
}