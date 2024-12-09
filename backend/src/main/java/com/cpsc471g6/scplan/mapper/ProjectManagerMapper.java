package com.cpsc471g6.scplan.mapper;

import com.cpsc471g6.scplan.dto.ProjectManagerDto;
import com.cpsc471g6.scplan.entity.ProjectManager;

public class ProjectManagerMapper {
	public static ProjectManagerDto mapToProjectManagerDto(ProjectManager projectManager) {
		return new ProjectManagerDto(
				projectManager.getEmployee().getId(),       // Employee ID
				projectManager.isPmpCertification()         // PMP Certification
		);
	}

	public static ProjectManager mapToProjectManager(ProjectManagerDto projectManagerDto) {
		ProjectManager projectManager = new ProjectManager();
		projectManager.setEmployeeId(projectManagerDto.getEmployeeId());
		projectManager.setPmpCertification(projectManagerDto.isPmpCertification());
		return projectManager;
	}
}