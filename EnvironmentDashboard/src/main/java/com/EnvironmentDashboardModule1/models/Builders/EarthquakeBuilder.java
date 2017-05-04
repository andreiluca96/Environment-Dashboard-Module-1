package com.EnvironmentDashboardModule1.models.Builders;

import com.EnvironmentDashboardModule1.models.Events.Earthquake;

import java.util.Date;

/**
 * Created by daioanei on 5/4/2017.
 */
public class EarthquakeBuilder {


    private Double richterDegree;

    private Double mercalliDegree;

    private Integer depth;

    private String name;

    private Double latitude;

    private Double longitude;

    private Date startingTime;

    private Date endingTime;

    private String severity;

    private String description;

    private String hints;

    private Double radius;

    public EarthquakeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public EarthquakeBuilder setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public EarthquakeBuilder setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public EarthquakeBuilder setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
        return this;
    }

    public EarthquakeBuilder setEndingTime(Date endingTime) {
        this.endingTime = endingTime;
        return this;
    }

    public EarthquakeBuilder setSeverity(String severity) {
        this.severity = severity;
        return this;
    }

    public EarthquakeBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public EarthquakeBuilder setHints(String hints) {
        this.hints = hints;
        return this;
    }

    public EarthquakeBuilder setRadius(Double radius) {
        this.radius = radius;
        return this;
    }

    public EarthquakeBuilder setRichterDegree(Double richterDegree) {
        this.richterDegree = richterDegree;
        return this;
    }

    public EarthquakeBuilder setMercalliDegree(Double mercalliDegree) {
        this.mercalliDegree = mercalliDegree;
        return this;
    }

    public EarthquakeBuilder setDepth(Integer depth) {
        this.depth = depth;
        return this;
    }


    public Earthquake getEarthquake(){
        Earthquake earthquake = new Earthquake();

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
