package com.cpsc471g6.scplan.repository;

import com.cpsc471g6.scplan.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}