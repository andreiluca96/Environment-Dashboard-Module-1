package com.EnvironmentDashboardModule1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Ariana on 5/3/2017.
 */
@Entity
@Table(name = "Flood")
public class Flood extends Event{

    private Double precipitationLevel;

    public Double getPrecipitationLevel() {
        return precipitationLevel;
    }

    public void setPrecipitationLevel(Double precipitationLevel) {
        this.precipitationLevek = precipitationLevel;
    }

}
