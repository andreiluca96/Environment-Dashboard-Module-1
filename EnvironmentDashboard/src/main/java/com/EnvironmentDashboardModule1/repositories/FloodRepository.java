package com.EnvironmentDashboardModule1.repositories;

import com.EnvironmentDashboardModule1.models.Events.Flood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FloodRepository extends JpaRepository<Flood, Long> {
}