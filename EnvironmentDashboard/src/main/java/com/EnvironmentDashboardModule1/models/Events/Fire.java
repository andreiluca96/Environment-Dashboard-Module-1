package com.EnvironmentDashboardModule1.models.Events;

import com.EnvironmentDashboardModule1.models.Events.Event;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Ariana on 5/3/2017.
 */

@Entity
public class Fire extends Event {
    private Double speed;

    public Double getSpeed() {
        return this.speed;
    }

    public void setSpeed(Double speed) {
        validateNonNegativeValue(speed);
        this.speed = speed;
    }
}
