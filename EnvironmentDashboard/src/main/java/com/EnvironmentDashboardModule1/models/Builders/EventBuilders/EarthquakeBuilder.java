package com.EnvironmentDashboardModule1.models.Builders.EventBuilders;

import com.EnvironmentDashboardModule1.models.Events.Earthquake;

import java.util.Date;

/**
 * Created by daioanei on 5/4/2017.
 */

public class EarthquakeBuilder extends EventBuilder{

    private Double richterDegree;

    private Double mercalliDegree;

    private Integer depth;


    public EarthquakeBuilder setName(String name) {
        validateString(name);
        this.name = name;
        return this;
    }

    public EarthquakeBuilder setLatitude(Double latitude) {
        validateLatitude(latitude);
        this.latitude = latitude;
        return this;
    }

    public EarthquakeBuilder setLongitude(Double longitude) {
        validateLongitude(longitude);
        this.longitude = longitude;
        return this;
    }

    public EarthquakeBuilder setStartingTime(Date startingTime) {
        validateTime(startingTime);
        this.startingTime = startingTime;
        return this;
    }

    public EarthquakeBuilder setEndingTime(Date endingTime) {
        validateTime(endingTime);
        this.endingTime = endingTime;
        return this;
    }

    public EarthquakeBuilder setSeverity(String severity) {
        validateSeverity(severity);
        this.severity = severity;
        return this;
    }

    public EarthquakeBuilder setDescription(String description) {
        validateString(description);
        this.description = description;
        return this;
    }

    public EarthquakeBuilder setHints(String hints) {
        validateString(hints);
        this.hints = hints;
        return this;
    }

    public EarthquakeBuilder setRadius(Double radius) {
        validateNonNegativeValue(radius);
        this.radius = radius;
        return this;
    }

    public EarthquakeBuilder setRichterDegree(Double richterDegree) {
        validateNonNegativeValue(richterDegree);
        this.richterDegree = richterDegree;
        return this;
    }

    public EarthquakeBuilder setMercalliDegree(Double mercalliDegree) {
        validateNonNegativeValue(mercalliDegree);
        this.mercalliDegree = mercalliDegree;
        return this;
    }

    public EarthquakeBuilder setDepth(Integer depth) {
        validateNonNegativeValue(depth);
        this.depth = depth;
        return this;
    }

    public EarthquakeBuilder setUserId(String userId) {
        this.userId = userId;

        return this;
    }

    public Earthquake getEarthquake(){
        Earthquake earthquake = new Earthquake();

        earthquake.setUserId(userId);
        earthquake.setLatitude(latitude);
        earthquake.setLongitude(longitude);
        earthquake.setDescription(description);
        earthquake.setEndingTime(endingTime);
        earthquake.setHints(hints);
        earthquake.setName(name);
        earthquake.setRadius(radius);
        earthquake.setSeverity(severity);
        earthquake.setStartingTime(startingTime);
        earthquake.setRichterDegree(richterDegree);
        earthquake.setMercalliDegree(mercalliDegree);
        earthquake.setDepth(depth);

        return earthquake;
    }

}
