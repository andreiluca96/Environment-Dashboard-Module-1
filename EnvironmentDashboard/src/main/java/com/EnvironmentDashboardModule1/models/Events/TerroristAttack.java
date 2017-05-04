package com.EnvironmentDashboardModule1.models.Events;

import com.EnvironmentDashboardModule1.models.Events.Event;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Ariana on 5/3/2017.
 */
@Entity
public class TerroristAttack extends Event {
    private Integer numberOfTerrorists;

    public Integer getNumberOfTerrorists() {
        return numberOfTerrorists;
    }

    public void setNumberOfTerrorists(Integer numberOfTerrorists) {
        this.numberOfTerrorists = numberOfTerrorists;
    }

}
