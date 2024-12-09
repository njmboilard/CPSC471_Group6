package com.cpsc471g6.scplan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class IssuesDto {
	private int id;
	private String description;
	private String status;
	private ProjectDto project;
	private EmployeeDto reportedBy;
}