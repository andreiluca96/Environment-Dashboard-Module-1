package com.EnvironmentDashboardModule1.DTO.Interfaces.TerroristAttackInterfaces;

import com.EnvironmentDashboardModule1.DTO.TerroristAttackDto;
import com.EnvironmentDashboardModule1.models.Events.TerroristAttack;

/**
 * Created by Luca Andrei on 5/4/2017.
 */
public interface INumberOfTerrorists {
    TerroristAttackDto numberOfTerrorists(Integer numberOfTerrorists);
}
