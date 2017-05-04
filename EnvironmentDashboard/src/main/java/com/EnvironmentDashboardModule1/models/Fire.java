package com.EnvironmentDashboardModule1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Ariana on 5/3/2017.
 */
@Entity
@Table(name = "Fire")
public class Fire extends Event{
    private Double speed;

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }
}
