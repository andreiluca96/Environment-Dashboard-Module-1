package com.EnvironmentDashboardModule1.repositories;

import com.EnvironmentDashboardModule1.models.Event;
import com.EnvironmentDashboardModule1.models.Flood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FloodRepository extends JpaRepository<Flood, Long> {
}