package com.EnvironmentDashboardModule1.repositories;

import com.EnvironmentDashboardModule1.models.Events.Tornado;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Luca Andrei on 5/4/2017.
 */
public interface TornadoRepository extends JpaRepository<Tornado, Long> {
}
