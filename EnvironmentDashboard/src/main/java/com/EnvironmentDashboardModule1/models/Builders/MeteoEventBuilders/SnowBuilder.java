package com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders;

import com.EnvironmentDashboardModule1.models.Builders.EventBuilders.EventBuilder;
import com.EnvironmentDashboardModule1.models.MeteoEvents.Snow;
import com.EnvironmentDashboardModule1.models.Severity;

import java.util.Date;


public class SnowBuilder extends EventBuilder{

    private Integer precipitationLevel;

    public SnowBuilder setName(String name) {
        validateString(name);
        this.name = name;
        return this;
    }

    public SnowBuilder setLatitude(Double latitude) {
        validateLatitude(latitude);
        this.latitude = latitude;
        return this;
    }

    public SnowBuilder setLongitude(Double longitude) {
        validateLongitude(longitude);
        this.longitude = longitude;
        return this;
    }

    public SnowBuilder setStartingTime(Date startingTime) {
        validateTime(startingTime);
        this.startingTime = startingTime;
        return this;
    }

    public SnowBuilder setEndingTime(Date endingTime) {
        validateTime(endingTime);
        this.endingTime = endingTime;
        return this;
    }

    public SnowBuilder setSeverity(Severity severity) {
        this.severity = severity;
        return this;
    }

    public SnowBuilder setDescription(String description) {
        validateString(description);
        this.description = description;
        return this;
    }

    public SnowBuilder setHints(String hints) {
        validateString(hints);
        this.hints = hints;
        return this;
    }

    public SnowBuilder setRadius(Double radius) {
        validateNonNegativeValue(radius);
        this.radius = radius;
        return this;
    }

    public SnowBuilder setPrecipitationLevel(Integer precipitationLevel) {
        validateNonNegativeValue(precipitationLevel);
        this.precipitationLevel = precipitationLevel;
        return this;
    }

    public SnowBuilder setUserId(String userId) {
        this.userId = userId;

        return this;
    }

    public Snow getSnow(){
        Snow snow = new Snow();

        snow.setUserId(userId);
        snow.setLatitude(latitude);
        snow.setLongitude(longitude);
        snow.setDescription(description);
        snow.setEndingTime(endingTime);
        snow.setHints(hints);
        snow.setName(name);
        snow.setRadius(radius);
        snow.setSeverity(severity);
        snow.setStartingTime(startingTime);
        snow.setPrecipitationLevel(precipitationLevel);

        return snow;
    }

}
