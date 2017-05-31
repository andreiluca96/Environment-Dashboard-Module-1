package com.EnvironmentDashboardModule1.models.Builders.EventBuilders;

import com.EnvironmentDashboardModule1.models.Events.Flood;
import com.EnvironmentDashboardModule1.models.Severity;

import java.util.Date;

/**
 * Created by daioanei on 5/4/2017.
 */

public class FloodBuilder extends EventBuilder{

    private Double precipitationLevel;

    public FloodBuilder setName(String name) {
        validateString(name);
        this.name = name;
        return this;
    }

    public FloodBuilder setLatitude(Double latitude) {
        validateLatitude(latitude);
        this.latitude = latitude;
        return this;
    }

    public FloodBuilder setLongitude(Double longitude) {
        validateLongitude(longitude);
        this.longitude = longitude;
        return this;
    }

    public FloodBuilder setStartingTime(Date startingTime) {
        validateTime(startingTime);
        this.startingTime = startingTime;
        return this;
    }

    public FloodBuilder setEndingTime(Date endingTime) {
        validateTime(endingTime);
        this.endingTime = endingTime;
        return this;
    }

    public FloodBuilder setSeverity(Severity severity) {
        this.severity = severity;
        return this;
    }

    public FloodBuilder setDescription(String description) {
        validateString(description);
        this.description = description;
        return this;
    }

    public FloodBuilder setHints(String hints) {
        validateString(hints);
        this.hints = hints;
        return this;
    }

    public FloodBuilder setRadius(Double radius) {
        validateNonNegativeValue(radius);
        this.radius = radius;
        return this;
    }

    public FloodBuilder setPrecipitationLevel(Double precipitationLevel) {
        validateNonNegativeValue(precipitationLevel);
        this.precipitationLevel = precipitationLevel;
        return this;
    }

    public FloodBuilder setUserId(String userId) {
        validateString(userId);
        this.userId = userId;
        return this;
    }

    public Flood getFlood(){
        Flood flood = new Flood();

        flood.setUserId(userId);
        flood.setLatitude(latitude);
        flood.setLongitude(longitude);
        flood.setDescription(description);
        flood.setEndingTime(endingTime);
        flood.setHints(hints);
        flood.setName(name);
        flood.setRadius(radius);
        flood.setSeverity(severity);
        flood.setStartingTime(startingTime);
        flood.setPrecipitationLevel(precipitationLevel);

        return flood;
    }

}
