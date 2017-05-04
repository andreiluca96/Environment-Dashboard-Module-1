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
        validate(speed);
        this.speed = speed;
    }

    // Dragos -> validate speed
    private void validate(Double speed) {
        if (speed < 0){
            throw new IllegalArgumentException(Double.toString(speed));
        }
    }
}
