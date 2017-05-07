package com.EnvironmentDashboardModule1.models.Builders;

import com.EnvironmentDashboardModule1.models.Events.Tsunami;

import java.util.Date;

/**
 * Created by daioanei on 5/4/2017.
 */

public class TsunamiBuilder extends EventBuilder{

    private Double maxWaveHeight;

    public TsunamiBuilder setName(String name) {
        validateString(name);
        this.name = name;
        return this;
    }

    public TsunamiBuilder setLatitude(Double latitude) {
        validateLatitude(latitude);
        this.latitude = latitude;
        return this;
    }

    public TsunamiBuilder setLongitude(Double longitude) {
        validateLongitude(longitude);
        this.longitude = longitude;
        return this;
    }

    public TsunamiBuilder setStartingTime(Date startingTime) {
        validateTime(startingTime);
        this.startingTime = startingTime;
        return this;
    }

    public TsunamiBuilder setEndingTime(Date endingTime) {
        validateTime(endingTime);
        this.endingTime = endingTime;
        return this;
    }

    public TsunamiBuilder setSeverity(String severity) {
        validateSeverity(severity);
        this.severity = severity;
        return this;
    }

    public TsunamiBuilder setDescription(String description) {
        validateString(description);
        this.description = description;
        return this;
    }

    public TsunamiBuilder setHints(String hints) {
        validateString(hints);
        this.hints = hints;
        return this;
    }

    public TsunamiBuilder setRadius(Double radius) {
        validateNonNegativeValue(radius);
        this.radius = radius;
        return this;
    }

    public TsunamiBuilder setMaxWaveHeight(Double maxWaveHeight) {
        validateNonNegativeValue(maxWaveHeight);
        this.maxWaveHeight = maxWaveHeight;
        return this;
    }

    public Tsunami getTsunami(){
        Tsunami tsunami = new Tsunami();

        tsunami.setLatitude(latitude);
        tsunami.setLongitude(longitude);
        tsunami.setDescription(description);
        tsunami.setEndingTime(endingTime);
        tsunami.setHints(hints);
        tsunami.setName(name);
        tsunami.setRadius(radius);
        tsunami.setSeverity(severity);
        tsunami.setStartingTime(startingTime);
        tsunami.setMaxWaveHeight(maxWaveHeight);

        return tsunami;
    }

}
