package com.cpsc471g6.scplan.repository;

import com.cpsc471g6.scplan.entity.Issues;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssuesRepository extends JpaRepository<Issues, Integer> {
}
