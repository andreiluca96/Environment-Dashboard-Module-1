package com.EnvironmentDashboardModule1.repositories;

import com.EnvironmentDashboardModule1.models.MeteoEvents.MeteoEvent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  Repository API for the Meteo Event entity. This interface acts primarily as a marker interface to capture the
 *  types to work with and help to discover interfaces that extend this one.
 *  For each entity, there is a interface with a repository API: Rain, Snow, Cold Weather etc.
 */
public interface MeteoEventRepository extends JpaRepository<MeteoEvent, Long> {
}