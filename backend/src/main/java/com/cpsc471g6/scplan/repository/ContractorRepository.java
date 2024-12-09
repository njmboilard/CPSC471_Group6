package com.cpsc471g6.scplan.repository;

import com.cpsc471g6.scplan.entity.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractorRepository extends JpaRepository<Contractor, Integer> {
}
