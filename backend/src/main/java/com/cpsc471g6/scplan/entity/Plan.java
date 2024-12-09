package com.cpsc471g6.scplan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "plan")

public class Plan {
	@EmbeddedId
	private PlanId planId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumns({
			@JoinColumn(name = "chop_code", referencedColumnName = "chop_code", insertable = false, updatable = false),
			@JoinColumn(name = "mileage", referencedColumnName = "mileage", insertable = false, updatable = false)
	})
	private Location location;
}