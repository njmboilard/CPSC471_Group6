package com.cpsc471g6.scplan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	private Region region;
}
