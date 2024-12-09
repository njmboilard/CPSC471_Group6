package com.cpsc471g6.scplan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ContractedOnDto {
	private int projectId;                  // ID of the associated project
	private int contractDesignerId;         // ID of the associated Contract Designer
	private String projectName;             // Project name for additional context
	private String contractDesignerName;    // Contract Designer name for additional context
}