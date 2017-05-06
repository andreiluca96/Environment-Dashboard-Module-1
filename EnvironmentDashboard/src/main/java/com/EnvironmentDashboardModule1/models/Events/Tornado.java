package com.EnvironmentDashboardModule1.models.Events;


import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Ariana on 5/3/2017.
 */

@Entity
@Table(name = "Tornado")
public class Tornado extends Event {

    private Double windSpeed;

    public Double getWindSpeed() {
        return this.windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        validateNonNegativeValue(windSpeed);
        this.windSpeed = windSpeed;
    }
}
