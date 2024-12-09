package com.cpsc471g6.scplan.repository;

import com.cpsc471g6.scplan.entity.WorksOn;
import com.cpsc471g6.scplan.entity.WorksOnId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorksOnRepository extends JpaRepository<WorksOn, WorksOnId> {
}
