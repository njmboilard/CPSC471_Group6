package com.cpsc471g6.scplan.repository;

import com.cpsc471g6.scplan.entity.Location;
import com.cpsc471g6.scplan.entity.LocationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, LocationId> {

}