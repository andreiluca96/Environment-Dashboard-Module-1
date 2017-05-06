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

    //Dragos -> validate severity
    private void validateSeverity(String severity) {
        if (!severity.equals("GREEN") && !severity.equals("YELLOW") && !severity.equals("ORANGE") && !severity.equals("RED")) {
            throw new IllegalArgumentException(severity);
        }
    }

    //Dragos -> validate latitude
    private void validateLatitude(Double latitude) {
        if (latitude < -85 || latitude > 85) {
            throw new IllegalArgumentException(Double.toString(latitude));
        }
    }

    //Dragos -> validate longitude
    private void validateLongitude(Double longitude) {
        if (longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException(Double.toString(longitude));
        }
    }

    //Dragos -> validate id
    private void validateId(Integer id) {
        if (id < 0) {
            throw new IllegalArgumentException(Double.toString(id));
        }
    }

    //Dragos -> validate name
    private void validateString(String name) {
        if (name == null) {
            throw new IllegalArgumentException(name);
        }
    }

    //Dragos -> validate time
    private void validateTime(Date time) {
        if (time == null) {
            throw new IllegalArgumentException("null time");
        }
    }

    //Dragos -> validate radius and mercalli/richter degrees
    private void validateNonNegativeValue(Double value) {
        if (value < 0) {
            throw new IllegalArgumentException(Double.toString(value));
        }
    }

    //Dragos -> validate depth
    private void validateNonNegativeValue(Integer value) {
        if (value < 0) {
            throw new IllegalArgumentException(Integer.toString(value));
        }
    }
}
