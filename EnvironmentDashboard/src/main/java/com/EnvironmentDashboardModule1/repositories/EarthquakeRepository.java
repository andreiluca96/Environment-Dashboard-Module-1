package com.EnvironmentDashboardModule1.repositories;

import com.EnvironmentDashboardModule1.models.Events.Earthquake;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EarthquakeRepository extends JpaRepository<Earthquake, Long> {
}