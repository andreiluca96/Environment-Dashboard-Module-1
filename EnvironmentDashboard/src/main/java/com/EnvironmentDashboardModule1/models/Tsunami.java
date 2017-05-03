package com.EnvironmentDashboardModule1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Ariana on 5/3/2017.
 */
@Entity
@Table(name = "Tsunami")
public class Tsunami extends Event{

    @Column(nullable = false)
    private Double maxWaveHeight;

    public Double getMaxWaveHeight() {
        return maxWaveHeight;
    }

    public void setMaxWaveHeight(Double maxWaveHeight) {
        this.maxWaveHeight = maxWaveHeight;
    }
}
