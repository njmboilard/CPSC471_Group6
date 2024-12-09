package com.cpsc471g6.scplan.service.impl;

import com.cpsc471g6.scplan.dto.LocationDto;
import com.cpsc471g6.scplan.dto.PlanDto;
import com.cpsc471g6.scplan.entity.*;
import com.cpsc471g6.scplan.exception.ResourceNotFoundException;
import com.cpsc471g6.scplan.mapper.LocationMapper;
import com.cpsc471g6.scplan.mapper.PlanMapper;
import com.cpsc471g6.scplan.mapper.SubdivisionMapper;
import com.cpsc471g6.scplan.repository.LocationRepository;
import com.cpsc471g6.scplan.repository.PlanRepository;
import com.cpsc471g6.scplan.service.PlanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class PlanServiceImpl implements PlanService {
	private PlanRepository planRepository;
	private LocationRepository locationRepository;

	@Override
	public PlanDto createPlan(PlanDto planDto, String chopCode, BigDecimal mileage) {
		LocationId locationId = new LocationId(chopCode, mileage);
		Location location = locationRepository.findById(locationId).orElseThrow(
				() -> new ResourceNotFoundException("Location " + chopCode + " " + mileage + " not found.")
		);

		PlanId planId = new PlanId(chopCode, mileage, planDto.getDrawingNumber());
		Plan plan = new Plan();
		plan.setPlanId(planId);
		plan.setLocation(location);

		Plan savedPlan = planRepository.save(plan);
		return PlanMapper.mapToPlanDto(savedPlan);
	}

	@Override
	public PlanDto getPlanById(String chopCode, BigDecimal mileage, String drawingNumber) {
		PlanId planId = new PlanId(chopCode, mileage, drawingNumber);
		Plan plan = planRepository.findById(planId).orElseThrow(
				() -> new ResourceNotFoundException("Plan set " + drawingNumber + " for " + chopCode + " " + mileage + " not found.")
		);
		return PlanMapper.mapToPlanDto(plan);
	}

	@Override
	public List<PlanDto> getAllPlans(String chopCode, BigDecimal mileage) {
		LocationId locationId = new LocationId(chopCode, mileage);
		Location location = locationRepository.findById(locationId).orElseThrow(
				() -> new ResourceNotFoundException("Location " + chopCode + " " + mileage + " not found.")
		);
		List<Plan> plans = location.getPlans();
		return plans.stream().map(PlanMapper::mapToPlanDto).collect(Collectors.toList());
	}

	@Override
	public PlanDto updatePlan(String oldChopCode, BigDecimal oldMileage, String oldDrawingNumber, PlanDto planDto) {
		// Create the old PlanId
		PlanId oldPlanId = new PlanId(oldChopCode, oldMileage, oldDrawingNumber);

		// Fetch the existing plan
		Plan existingPlan = planRepository.findById(oldPlanId).orElseThrow(
				() -> new ResourceNotFoundException("Plan with drawing number " + oldDrawingNumber +
						" for " + oldChopCode + " " + oldMileage + " not found.")
		);

		// Check if any part of the composite key is changing
		boolean isKeyChanging = !oldChopCode.equals(planDto.getChopCode()) ||
				!oldMileage.equals(planDto.getMileage()) ||
				!oldDrawingNumber.equals(planDto.getDrawingNumber());

		if (isKeyChanging) {
			// Fetch the new Location for the updated chopCode and mileage
			LocationId newLocationId = new LocationId(planDto.getChopCode(), planDto.getMileage());
			Location newLocation = locationRepository.findById(newLocationId).orElseThrow(
					() -> new ResourceNotFoundException("Location " + planDto.getChopCode() +
							" " + planDto.getMileage() + " not found.")
			);

			// Create a new PlanId
			PlanId newPlanId = new PlanId(planDto.getChopCode(), planDto.getMileage(), planDto.getDrawingNumber());

			// Remove the old plan from the session (detaching it)
			planRepository.delete(existingPlan);

			// Create a new Plan entity with the updated keys and details
			Plan updatedPlan = PlanMapper.mapToPlan(planDto, newLocation);
			updatedPlan.setPlanId(newPlanId); // Set the new composite key

			// Save the new plan and return the DTO
			Plan savedPlan = planRepository.save(updatedPlan);
			return PlanMapper.mapToPlanDto(savedPlan);
		}

		// If keys are not changing, simply return the existing plan
		return PlanMapper.mapToPlanDto(existingPlan);
	}

	@Override
	public void deletePlan(String chopCode, BigDecimal mileage, String drawingNumber) {
		// Create the composite key
		PlanId planId = new PlanId(chopCode, mileage, drawingNumber);

		// Check if the plan exists
		Plan existingPlan = planRepository.findById(planId).orElseThrow(
				() -> new ResourceNotFoundException("Plan set " + drawingNumber + " for " + chopCode + " " + mileage + " not found.")
		);

		// Delete the plan
		planRepository.delete(existingPlan);
	}
}