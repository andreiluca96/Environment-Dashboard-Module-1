package com.EnvironmentDashboardModule1.repositories;

import com.EnvironmentDashboardModule1.models.MeteoEvents.CanicularWeather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CanicularWeatherRepository extends JpaRepository<CanicularWeather, Long> {
}