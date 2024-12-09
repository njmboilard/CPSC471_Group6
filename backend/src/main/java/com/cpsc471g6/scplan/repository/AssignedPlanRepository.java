package com.cpsc471g6.scplan.repository;

import com.cpsc471g6.scplan.entity.AssignedPlan;
import com.cpsc471g6.scplan.entity.PlanId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignedPlanRepository extends JpaRepository<AssignedPlan, PlanId> {
}