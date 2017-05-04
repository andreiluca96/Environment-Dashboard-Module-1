package com.EnvironmentDashboardModule1.repositories;

import com.EnvironmentDashboardModule1.models.MeteoEvents.Rain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RainRepository extends JpaRepository<Rain, Long> {
}