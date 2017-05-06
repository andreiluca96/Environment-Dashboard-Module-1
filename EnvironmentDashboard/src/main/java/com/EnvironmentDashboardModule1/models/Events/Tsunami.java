package com.EnvironmentDashboardModule1.models.Events;

import com.EnvironmentDashboardModule1.models.Events.Event;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Ariana on 5/3/2017.
 */
@Entity
public class Tsunami extends Event {

    private Double maxWaveHeight;

    public Double getMaxWaveHeight() {
        return this.maxWaveHeight;
    }

    public void setMaxWaveHeight(Double maxWaveHeight) {
        validateNonNegativeValue(maxWaveHeight);
        this.maxWaveHeight = maxWaveHeight;
    }
}
