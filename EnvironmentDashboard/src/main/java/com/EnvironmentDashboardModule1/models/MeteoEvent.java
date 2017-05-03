package com.EnvironmentDashboardModule1.models;

import javax.persistence.*;

/**
 * Created by Ariana on 5/3/2017.
 */
@Entity
@Table(name = " MeteoEvent")
public class MeteoEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Integer temperature;

    @Column(nullable = false)
    private Integer humidity;

    @Column(nullable = false)
    private Integer precipitationLevel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getPrecipitationLevel() {
        return precipitationLevel;
    }

    public void setPrecipitationLevel(Integer precipitationLevel) {
        this.precipitationLevel = precipitationLevel;
    }

}
