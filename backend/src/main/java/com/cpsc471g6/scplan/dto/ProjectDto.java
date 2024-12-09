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

public class ProjectDto {
	private int id;
	private int year;
	private String projectName;
	private String projectStatus;
	private InHouseDesignerDto designLead;
	private List<AssignedPlanDto> assignedPlans;
	private List<IssuesDto> issues;
	private List<WorksOnDto> worksOn;
	private List<ContractedOnDto> contractedOn;
}
