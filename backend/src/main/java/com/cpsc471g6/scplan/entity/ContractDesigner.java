package com.cpsc471g6.scplan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contract_designer")
public class ContractDesigner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "name", nullable = false)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "contractor_id", nullable = false)
	@OnDelete(action = OnDeleteAction.RESTRICT)
	private Contractor contractor;

	@OneToMany(mappedBy = "contractDesigner", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ContractedOn> contractedOnList = new ArrayList<>();
}