package com.EnvironmentDashboardModule1.models.Events;

import com.EnvironmentDashboardModule1.models.Events.Event;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Ariana on 5/3/2017.
 */
@Entity
public class Flood extends Event {

    private Double precipitationLevel;

    public Double getPrecipitationLevel() {
        return precipitationLevel;
    }

    public void setPrecipitationLevel(Double precipitationLevel) {
        if (precipitationLevel < 0) {
            throw new IllegalArgumentException(Double.toString(precipitationLevel));
        }
        this.precipitationLevel = precipitationLevel;
    }

}
