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
@Table(name = "contracted_on")
public class ContractedOn {
	@EmbeddedId
	private ContractedOnId id; // Composite primary key

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("projectId") // Maps this field to the projectId in the composite key
	@JoinColumn(name = "project_id", nullable = false)
	private Project project;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("contractDesignerId") // Maps this field to the contractDesignerId in the composite key
	@JoinColumn(name = "contract_designer_id", nullable = false)
	private ContractDesigner contractDesigner;
}