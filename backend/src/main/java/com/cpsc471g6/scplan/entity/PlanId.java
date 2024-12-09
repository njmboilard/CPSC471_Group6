package com.cpsc471g6.scplan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class PlanId implements Serializable {
	@Column(name = "chop_code", nullable = false)
	private String chopCode;

	@Column(name = "mileage", nullable = false, precision = 5, scale = 2)
	private BigDecimal mileage;

	@Column(name = "drawing_number", nullable = false)
	private String drawingNumber;
}