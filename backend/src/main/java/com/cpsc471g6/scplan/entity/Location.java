package com.cpsc471g6.scplan.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name="location")

public class Location {
	@EmbeddedId
	private LocationId id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@MapsId("chopCode") // Maps 'chopCode' in LocationId to Subdivision's primary key
	@JoinColumn(name="chop_code", nullable = false)
	@OnDelete(action = OnDeleteAction.RESTRICT)
	@JsonIgnoreProperties({"region"})
	private Subdivision subdivision;

	@Column(name="location_type", nullable = false)
	private String locationType;

	@Column(name="location_name")
	private String locationName;

	@OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Plan> plans = new ArrayList<>();
}