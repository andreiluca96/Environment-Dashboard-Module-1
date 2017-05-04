package com.EnvironmentDashboardModule1.repositories;

import com.EnvironmentDashboardModule1.models.MeteoEvents.Snow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnowRepository extends JpaRepository<Snow, Long> {
}