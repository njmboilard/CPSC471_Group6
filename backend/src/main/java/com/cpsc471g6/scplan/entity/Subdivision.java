package com.cpsc471g6.scplan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "subdivision")

public class Subdivision {
	@Id
	@Column(name="chop_code", nullable = false, unique = true)
	private String chopCode;

	@Column(name="name", nullable = false, unique = true)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="region_id", nullable = false)
	@OnDelete(action = OnDeleteAction.RESTRICT)
	@JsonIgnore
	private Region region;

	@OneToMany(mappedBy = "subdivision", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Location> locations = new ArrayList<>();
}
