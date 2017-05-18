package com.EnvironmentDashboardModule1.DTO;

/**
 * Created by Sabina on 5/19/2017.
 */

public class CreatingTerroristAttackDto extends CreatingEventDto{
    protected Integer numberOfTerrorists;

    public Integer getNumberOfTerrorists() {
        return numberOfTerrorists;
    }

    public void setNumberOfTerrorists(Integer numberOfTerrorists) {
        this.numberOfTerrorists = numberOfTerrorists;
    }
}
