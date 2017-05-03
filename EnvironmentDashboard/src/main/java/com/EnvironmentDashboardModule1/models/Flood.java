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

    @Column(nullable = false)
    private Double precipitationLevek;

    public Double getPrecipitationLevek() {
        return precipitationLevek;
    }

    public void setPrecipitationLevek(Double precipitationLevek) {
        this.precipitationLevek = precipitationLevek;
    }

}
