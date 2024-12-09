package com.cpsc471g6.scplan.repository;

import com.cpsc471g6.scplan.entity.ContractedOn;
import com.cpsc471g6.scplan.entity.ContractedOnId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractedOnRepository extends JpaRepository<ContractedOn, ContractedOnId> {
}
