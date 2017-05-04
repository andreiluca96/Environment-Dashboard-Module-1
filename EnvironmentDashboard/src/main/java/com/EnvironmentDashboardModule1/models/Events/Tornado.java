package com.EnvironmentDashboardModule1.models.Events;

import com.EnvironmentDashboardModule1.models.Events.Event;

import javax.persistence.Entity;

/**
 * Created by Ariana on 5/3/2017.
 */
@Entity
public class Tornado extends Event {
    private Double windSpeed;

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

}
