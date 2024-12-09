package com.cpsc471g6.scplan.repository;

import com.cpsc471g6.scplan.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}