package com.cpsc471g6.scplan.service.impl;

import com.cpsc471g6.scplan.dto.AssignedPlanDto;
import com.cpsc471g6.scplan.entity.AssignedPlan;
import com.cpsc471g6.scplan.entity.Plan;
import com.cpsc471g6.scplan.entity.PlanId;
import com.cpsc471g6.scplan.entity.Project;
import com.cpsc471g6.scplan.exception.ResourceNotFoundException;
import com.cpsc471g6.scplan.mapper.AssignedPlanMapper;
import com.cpsc471g6.scplan.repository.AssignedPlanRepository;
import com.cpsc471g6.scplan.repository.PlanRepository;
import com.cpsc471g6.scplan.repository.ProjectRepository;
import com.cpsc471g6.scplan.service.AssignedPlanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AssignedPlanServiceImpl implements AssignedPlanService {
	private AssignedPlanRepository assignedPlanRepository;
	private ProjectRepository projectRepository;
	private PlanRepository planRepository;

	@Override
	public AssignedPlanDto createAssignedPlan(AssignedPlanDto assignedPlanDto) {
		PlanId planId = new PlanId(
				assignedPlanDto.getChopCode(),
				assignedPlanDto.getMileage(),
				assignedPlanDto.getDrawingNumber()
		);

		// Fetch the Plan entity
		Plan plan = planRepository.findById(planId).orElseThrow(
				() -> new ResourceNotFoundException("Plan not found.")
		);

		// Fetch the Project entity
		Project project = projectRepository.findById(assignedPlanDto.getProjectId()).orElseThrow(
				() -> new ResourceNotFoundException("Project not found.")
		);

		// Map DTO to entity
		AssignedPlan assignedPlan = AssignedPlanMapper.mapToAssignedPlan(assignedPlanDto);
		assignedPlan.setPlan(plan);  // Link to Plan
		assignedPlan.setProject(project);  // Link to Project

		// Save AssignedPlan
		AssignedPlan savedPlan = assignedPlanRepository.save(assignedPlan);

		return AssignedPlanMapper.mapToAssignedPlanDto(savedPlan);
	}

	@Override
	public AssignedPlanDto getAssignedPlanById(String chopCode, BigDecimal mileage, String drawingNumber) {
		PlanId planId = new PlanId(chopCode, mileage, drawingNumber);
		AssignedPlan assignedPlan = assignedPlanRepository.findById(planId).orElseThrow(
				() -> new ResourceNotFoundException("AssignedPlan with ID " + planId + " not found.")
		);
		return AssignedPlanMapper.mapToAssignedPlanDto(assignedPlan);
	}

	@Override
	public List<AssignedPlanDto> getAllAssignedPlans() {
		List<AssignedPlan> assignedPlans = assignedPlanRepository.findAll();
		return assignedPlans.stream()
				.map(AssignedPlanMapper::mapToAssignedPlanDto)
				.collect(Collectors.toList());
	}

	@Override
	public AssignedPlanDto updateAssignedPlan(String chopCode, BigDecimal mileage, String drawingNumber, AssignedPlanDto assignedPlanDto) {
		PlanId planId = new PlanId(chopCode, mileage, drawingNumber);
		AssignedPlan assignedPlan = assignedPlanRepository.findById(planId).orElseThrow(
				() -> new ResourceNotFoundException("AssignedPlan with ID " + planId + " not found.")
		);

		// Update project association if provided
		if (assignedPlanDto.getProjectId() != 0) { // Assuming 0 means no update
			Project project = projectRepository.findById(assignedPlanDto.getProjectId())
					.orElseThrow(() -> new ResourceNotFoundException("Project with ID " + assignedPlanDto.getProjectId() + " not found."));
			assignedPlan.setProject(project);
		}

		// Update other fields (if applicable)
//		assignedPlan.setArchiveStatus(assignedPlanDto.getArchiveStatus());
		assignedPlan.setAssignedStatus(assignedPlanDto.isAssignedStatus());

		// Save and return the updated entity
		AssignedPlan updatedPlan = assignedPlanRepository.save(assignedPlan);
		return AssignedPlanMapper.mapToAssignedPlanDto(updatedPlan);
	}

	@Override
	public void deleteAssignedPlan(String chopCode, BigDecimal mileage, String drawingNumber) {
		PlanId planId = new PlanId(chopCode, mileage, drawingNumber);
		AssignedPlan assignedPlan = assignedPlanRepository.findById(planId).orElseThrow(
				() -> new ResourceNotFoundException("AssignedPlan with ID " + planId + " not found.")
		);
		assignedPlanRepository.delete(assignedPlan);
	}
}