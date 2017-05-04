package com.EnvironmentDashboardModule1.repositories;

import com.EnvironmentDashboardModule1.models.MeteoEvents.Fog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FogRepository extends JpaRepository<Fog, Long> {
}