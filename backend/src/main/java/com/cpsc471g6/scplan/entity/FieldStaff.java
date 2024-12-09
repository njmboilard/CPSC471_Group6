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
@Table(name = "field_staff")

public class FieldStaff {
	@Id
	@Column(name = "employee_id")
	private int employeeId;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "employee_id", referencedColumnName = "id")
	private Employee employee;

	@Column(name = "position", nullable = false)
	private String position;
}
