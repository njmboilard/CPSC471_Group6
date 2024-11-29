package com.cpsc471g6.scplan.repository;

import com.cpsc471g6.scplan.entity.Subdivision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubdivisionRepository extends JpaRepository<Subdivision, String> {

}