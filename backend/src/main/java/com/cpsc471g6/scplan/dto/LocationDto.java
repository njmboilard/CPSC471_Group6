package com.cpsc471g6.scplan.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class LocationDto {
	private String chopCode;
	private BigDecimal mileage;
	private String locationType;
	private String locationName;
	private List<PlanDto> plans;
}