package com.EnvironmentDashboardModule1.repositories;

import com.EnvironmentDashboardModule1.models.MeteoEvents.MeteoEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeteoEventRepository extends JpaRepository<MeteoEvent, Long> {
}