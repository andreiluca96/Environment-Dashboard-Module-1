package com.EnvironmentDashboardModule1.repositories;

import com.EnvironmentDashboardModule1.models.MeteoEvents.ColdWeather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColdWeatherRepository extends JpaRepository<ColdWeather, Long> {
}