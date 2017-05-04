package com.EnvironmentDashboardModule1.repositories;

import com.EnvironmentDashboardModule1.models.Events.Fire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FireRepository extends JpaRepository<Fire, Long> {
}