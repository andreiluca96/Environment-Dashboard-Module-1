package com.EnvironmentDashboardModule1.models.MeteoEvents;

import javax.persistence.*;

/**
 * Created by Ariana on 5/3/2017.
 */
@Entity
public class MeteoEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    protected Long id;

    @Column(nullable = false)
    protected Integer temperature;

    @Column(nullable = false)
    protected Integer humidity;

    @Column(nullable = false)
    protected Integer precipitationLevel;

    public Long getId() { return this.id; }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTemperature() {
        return this.temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getHumidity() {
        return this.humidity;
    }

    public void setHumidity(Integer humidity) {
        validateNonNegativeValue(humidity);
        this.humidity = humidity;
    }

    public Integer getPrecipitationLevel() {
        return this.precipitationLevel;
    }

    public void setPrecipitationLevel(Integer precipitationLevel) {
        validateNonNegativeValue(precipitationLevel);
        this.precipitationLevel = precipitationLevel;
    }

    //Dragos -> validate integer values
    protected void validateNonNegativeValue(Integer value) {
        if (value < 0) {
            throw new IllegalArgumentException(Integer.toString(value));
        }
    }
}
