package com.EnvironmentDashboardModule1.repositories;

import com.EnvironmentDashboardModule1.models.Events.TerroristAttack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerroristAttackRepository extends JpaRepository<TerroristAttack, Long> {
}