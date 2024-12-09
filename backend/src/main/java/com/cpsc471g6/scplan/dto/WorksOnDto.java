package com.cpsc471g6.scplan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class WorksOnDto {
	private int projectId;          // ID of the associated project
	private int employeeId;         // ID of the associated employee
	private String projectName;     // Project name for additional context (optional)
	private String employeeName;    // Employee name for additional context (optional)
}