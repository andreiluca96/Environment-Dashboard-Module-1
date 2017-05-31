package com.EnvironmentDashboardModule1.models.MeteoEvents;

import com.EnvironmentDashboardModule1.models.Events.Earthquake;
import com.EnvironmentDashboardModule1.models.Events.Event;

import javax.persistence.*;

/**
 * Created by Ariana on 5/3/2017.
 */
@Entity
public class MeteoEvent extends Event{

    protected Integer temperature;

    protected Integer humidity;

    protected Integer precipitationLevel;

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

}
