package com.cpsc471g6.scplan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubdivisionDto {
	private String chopCode;
	private String name;
	private int regionId;
	private List<LocationDto> locations;
}
