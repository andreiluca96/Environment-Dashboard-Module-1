package com.EnvironmentDashboardModule1.models.Events;

import com.EnvironmentDashboardModule1.models.Events.Event;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Ariana on 5/3/2017.
 */

@Entity
@Table(name = "TerroristAttack")
public class TerroristAttack extends Event {
    private Integer numberOfTerrorists;

    public Integer getNumberOfTerrorists() {
        return this.numberOfTerrorists;
    }

    public void setNumberOfTerrorists(Integer numberOfTerrorists) {
        validate(numberOfTerrorists);
        this.numberOfTerrorists = numberOfTerrorists;
    }

    // Dragos -> validate numberOfTerrorists
    private void validate(Integer numberOfTerrorists) {
        if (numberOfTerrorists < 0){
            throw new IllegalArgumentException(Integer.toString(numberOfTerrorists));
        }
    }

}
