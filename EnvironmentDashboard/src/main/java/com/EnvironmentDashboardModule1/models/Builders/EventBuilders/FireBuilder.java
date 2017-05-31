package com.EnvironmentDashboardModule1.models.Builders.EventBuilders;

import com.EnvironmentDashboardModule1.models.Events.Fire;

import java.util.Date;

/**
 * Created by daioanei on 5/4/2017.
 */

public class FireBuilder extends EventBuilder{

    private Double speed;

    public FireBuilder setName(String name) {
        validateString(name);
        this.name = name;
        return this;
    }

    public FireBuilder setLatitude(Double latitude) {
        validateLatitude(latitude);
        this.latitude = latitude;
        return this;
    }

    public FireBuilder setLongitude(Double longitude) {
        validateLongitude(longitude);
        this.longitude = longitude;
        return this;
    }

    public FireBuilder setStartingTime(Date startingTime) {
        validateTime(startingTime);
        this.startingTime = startingTime;
        return this;
    }

    public FireBuilder setEndingTime(Date endingTime) {
        validateTime(endingTime);
        this.endingTime = endingTime;
        return this;
    }

    public FireBuilder setSeverity(String severity) {
        validateSeverity(severity);
        this.severity = severity;
        return this;
    }

    public FireBuilder setDescription(String description) {
        validateString(description);
        this.description = description;
        return this;
    }

    public FireBuilder setHints(String hints) {
        validateString(hints);
        this.hints = hints;
        return this;
    }

    public FireBuilder setRadius(Double radius) {
        validateNonNegativeValue(radius);
        this.radius = radius;
        return this;
    }

    public FireBuilder setSpeed(Double speed) {
        validateNonNegativeValue(speed);
        this.speed = speed;
        return this;
    }

    public Fire getFire(){
        Fire fire = new Fire();

        fire.setUserId(userId);
        fire.setLatitude(latitude);
        fire.setLongitude(longitude);
        fire.setDescription(description);
        fire.setEndingTime(endingTime);
        fire.setHints(hints);
        fire.setName(name);
        fire.setRadius(radius);
        fire.setSeverity(severity);
        fire.setStartingTime(startingTime);
        fire.setSpeed(speed);

        return fire;
    }

}
