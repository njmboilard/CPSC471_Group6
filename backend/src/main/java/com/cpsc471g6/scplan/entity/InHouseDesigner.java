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
@Table(name = "in_house_designer")

public class InHouseDesigner {
	@Id
	@Column(name = "employee_id")
	private int employeeId;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "employee_id", referencedColumnName = "id")
	private Employee employee;

	@Column(name = "peng_certification", nullable = false)
	private boolean pengCertification;

	@Column(name = "initials", nullable = false, unique = true)
	private String initials;

	@OneToOne(mappedBy = "designLead")
	private Project project;
}