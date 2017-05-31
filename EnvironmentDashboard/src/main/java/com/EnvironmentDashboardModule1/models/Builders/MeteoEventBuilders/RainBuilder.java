package com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders;

import com.EnvironmentDashboardModule1.models.MeteoEvents.Rain;
import com.EnvironmentDashboardModule1.models.Severity;

import java.util.Date;

/**
 * Created by Andrei Sfarghiu on 5/13/2017.
 */


public class RainBuilder extends MeteoEventBuilder{

    private Integer temperature;

    private Integer humidity;

    private Integer precipitationLevel;

    public RainBuilder setName(String name) {
        validateString(name);
        this.name = name;
        return this;
    }

    public RainBuilder setLatitude(Double latitude) {
        validateLatitude(latitude);
        this.latitude = latitude;
        return this;
    }

    public RainBuilder setLongitude(Double longitude) {
        validateLongitude(longitude);
        this.longitude = longitude;
        return this;
    }

    public RainBuilder setStartingTime(Date startingTime) {
        validateTime(startingTime);
        this.startingTime = startingTime;
        return this;
    }

    public RainBuilder setEndingTime(Date endingTime) {
        validateTime(endingTime);
        this.endingTime = endingTime;
        return this;
    }

    public RainBuilder setSeverity(Severity severity) {
        this.severity = severity;
        return this;
    }

    public RainBuilder setDescription(String description) {
        validateString(description);
        this.description = description;
        return this;
    }

    public RainBuilder setHints(String hints) {
        validateString(hints);
        this.hints = hints;
        return this;
    }

    public RainBuilder setRadius(Double radius) {
        validateNonNegativeValue(radius);
        this.radius = radius;
        return this;
    }

    public RainBuilder setTemperature(Integer temperature) {
        this.temperature = temperature;
        return this;
    }

    public RainBuilder setHumidity(Integer humidity) {
        validateNonNegativeValue(humidity);
        this.humidity = humidity;
        return this;
    }

    public RainBuilder setPrecipitationLevel(Integer precipitationLevel) {
        validateNonNegativeValue(precipitationLevel);
        this.precipitationLevel = precipitationLevel;
        return this;
    }

    public RainBuilder setUserId(String userId) {
        this.userId = userId;

        return this;
    }


    public Rain getRain() {
        Rain rain=new Rain();

        rain.setUserId(userId);
        rain.setLatitude(latitude);
        rain.setLongitude(longitude);
        rain.setDescription(description);
        rain.setEndingTime(endingTime);
        rain.setHints(hints);
        rain.setName(name);
        rain.setRadius(radius);
        rain.setSeverity(severity);
        rain.setStartingTime(startingTime);
        rain.setHumidity(humidity);
        rain.setPrecipitationLevel(precipitationLevel);
        rain.setTemperature(temperature);
        return rain;
    }

    
    protected void validateNonNegativeValue(Integer value) {
        if (value < 0) {
            throw new IllegalArgumentException(Integer.toString(value));
        }
    }
}