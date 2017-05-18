package com.EnvironmentDashboardModule1.repositories;

import com.EnvironmentDashboardModule1.models.EventMapping;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Luca Andrei on 5/18/2017.
 */
public interface EventMappingRepository extends JpaRepository<EventMapping, Long> {
}
