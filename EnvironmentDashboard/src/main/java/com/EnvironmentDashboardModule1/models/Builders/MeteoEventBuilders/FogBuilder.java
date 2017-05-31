package com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders;

import com.EnvironmentDashboardModule1.models.MeteoEvents.Fog;

import java.util.Date;

/**
 * Created by Andrei Sfarghiu on 5/13/2017.
 */


public class FogBuilder extends MeteoEventBuilder{

    private Integer temperature;

    private Integer humidity;

    private Integer precipitationLevel;

    public FogBuilder setName(String name) {
        validateString(name);
        this.name = name;
        return this;
    }

    public FogBuilder setLatitude(Double latitude) {
        validateLatitude(latitude);
        this.latitude = latitude;
        return this;
    }

    public FogBuilder setLongitude(Double longitude) {
        validateLongitude(longitude);
        this.longitude = longitude;
        return this;
    }

    public FogBuilder setStartingTime(Date startingTime) {
        validateTime(startingTime);
        this.startingTime = startingTime;
        return this;
    }

    public FogBuilder setEndingTime(Date endingTime) {
        validateTime(endingTime);
        this.endingTime = endingTime;
        return this;
    }

    public FogBuilder setSeverity(String severity) {
        validateSeverity(severity);
        this.severity = severity;
        return this;
    }

    public FogBuilder setDescription(String description) {
        validateString(description);
        this.description = description;
        return this;
    }

    public FogBuilder setHints(String hints) {
        validateString(hints);
        this.hints = hints;
        return this;
    }

    public FogBuilder setRadius(Double radius) {
        validateNonNegativeValue(radius);
        this.radius = radius;
        return this;
    }

    public FogBuilder setTemperature(Integer temperature) {
        this.temperature = temperature;
        return this;
    }

    public FogBuilder setHumidity(Integer humidity) {
        validateNonNegativeValue(humidity);
        this.humidity = humidity;
        return this;
    }

    public FogBuilder setPrecipitationLevel(Integer precipitationLevel) {
        validateNonNegativeValue(precipitationLevel);
        this.precipitationLevel = precipitationLevel;
        return this;
    }

    public FogBuilder setUserId(String userId) {
        this.userId = userId;

        return this;
    }


    public Fog getFog() {
        Fog fog=new Fog();

        fog.setUserId(userId);
        fog.setLatitude(latitude);
        fog.setLongitude(longitude);
        fog.setDescription(description);
        fog.setEndingTime(endingTime);
        fog.setHints(hints);
        fog.setName(name);
        fog.setRadius(radius);
        fog.setSeverity(severity);
        fog.setStartingTime(startingTime);
        fog.setHumidity(humidity);
        fog.setPrecipitationLevel(precipitationLevel);
        fog.setTemperature(temperature);
        return fog;
    }

    
    protected void validateNonNegativeValue(Integer value) {
        if (value < 0) {
            throw new IllegalArgumentException(Integer.toString(value));
        }
    }
}