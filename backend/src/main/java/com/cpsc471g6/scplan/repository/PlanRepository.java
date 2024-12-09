package com.cpsc471g6.scplan.repository;

import com.cpsc471g6.scplan.entity.Plan;
import com.cpsc471g6.scplan.entity.PlanId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, PlanId> {

}