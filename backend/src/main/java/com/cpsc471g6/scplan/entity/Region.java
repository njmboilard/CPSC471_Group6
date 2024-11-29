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
@Table(name = "region")
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="name", nullable = false, unique = true)
	private String name;

	@OneToMany(mappedBy = "region", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Subdivision> subdivisions = new ArrayList<>();
}
