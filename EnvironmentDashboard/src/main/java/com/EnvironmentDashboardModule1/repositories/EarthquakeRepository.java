package com.EnvironmentDashboardModule1.repositories;

import com.EnvironmentDashboardModule1.models.Event;
import com.EnvironmentDashboardModule1.models.Earthquake;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EarthquakeRepository extends JpaRepository<Earthquake, Long> {
}