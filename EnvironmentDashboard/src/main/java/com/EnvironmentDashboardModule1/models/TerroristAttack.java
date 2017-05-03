package com.EnvironmentDashboardModule1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Ariana on 5/3/2017.
 */
@Entity
@Table(name = "TerroristAttack")
public class TerroristAttack extends Event{

    @Column(nullable = false)
    private Integer numberOfTerrorists;

    public Integer getNumberOfTerrorists() {
        return numberOfTerrorists;
    }

    public void setNumberOfTerrorists(Integer numberOfTerrorists) {
        this.numberOfTerrorists = numberOfTerrorists;
    }

}
