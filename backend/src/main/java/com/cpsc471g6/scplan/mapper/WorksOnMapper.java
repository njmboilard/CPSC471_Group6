package com.cpsc471g6.scplan.mapper;

import com.cpsc471g6.scplan.dto.WorksOnDto;
import com.cpsc471g6.scplan.entity.WorksOn;
import com.cpsc471g6.scplan.entity.WorksOnId;

public class WorksOnMapper {
	public static WorksOnDto mapToWorksOnDto(WorksOn worksOn) {
		return new WorksOnDto(
				worksOn.getId().getProjectId(),
				worksOn.getId().getEmployeeId(),
				worksOn.getProject() != null ? worksOn.getProject().getProjectName() : null, // Fetch project name
				worksOn.getEmployee() != null ? worksOn.getEmployee().getName() : null       // Fetch employee name
		);
	}

	public static WorksOn mapToWorksOn(WorksOnDto worksOnDto) {
		WorksOn worksOn = new WorksOn();
		worksOn.setId(new WorksOnId(worksOnDto.getProjectId(), worksOnDto.getEmployeeId()));

		// Note: Need to fetch and set Project and Employee entities in the service layer
		return worksOn;
	}
}