package com.EnvironmentDashboardModule1.repositories;

import com.EnvironmentDashboardModule1.models.Event;
import com.EnvironmentDashboardModule1.models.Tsunami;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TsunamiRepository extends JpaRepository<Tsunami, Long> {
}