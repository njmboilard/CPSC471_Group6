package com.cpsc471g6.scplan.repository;

import com.cpsc471g6.scplan.entity.ArchivePlan;
import com.cpsc471g6.scplan.entity.PlanId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ArchivePlanRepository extends JpaRepository<ArchivePlan, PlanId> {
	// Custom query to find all Archive Plans for a specific Location
	@Query("SELECT ap FROM ArchivePlan ap WHERE ap.planId.chopCode = :chopCode AND ap.planId.mileage = :mileage")
	List<ArchivePlan> findByLocation(@Param("chopCode") String chopCode, @Param("mileage") BigDecimal mileage);
}