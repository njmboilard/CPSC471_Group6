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
@Table(name = "document_controller")

public class DocumentController {
	@Id
	@Column(name = "employee_id", nullable = false)
	private int employeeId;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
	private Employee employee;

	@Column(name = "role", nullable = false)
	private String role;
}
