package com.EnvironmentDashboardModule1.models.Events;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by Luca Andrei on 5/3/2017.
 */

@Entity
@Table(name = "Event")
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String name;

    protected Date startingTime;

    protected Date endingTime;

    protected String severity;

    protected String description;

    protected String hints;

    protected Double latitude;

    protected Double longitude;

    protected Double radius;

    public String getSeverity() {
        return this.severity;
    }

    public void setSeverity(String severity) {
        validateSeverity(severity);
        this.severity = severity;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        validateLatitude(latitude);
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        validateLongitude(longitude);
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        validateId(id);
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        validateString(name);
        this.name = name;
    }

    public Date getStartingTime() {
        return this.startingTime;
    }

    public void setStartingTime(Date startingTime) {
        validateTime(startingTime);
        this.startingTime = startingTime;
    }

    public Date getEndingTime() {
        return this.endingTime;
    }

    public void setEndingTime(Date endingTime) {
        validateTime(endingTime);
        this.endingTime = endingTime;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        validateString(description);
        this.description = description;
    }

    public String getHints() { return this.hints; }

    public void setHints(String hints) {
        validateString(hints);
        this.hints = hints;
    }

    public Double getRadius() { return this.radius; }

    public void setRadius(Double radius) {
        validateNonNegativeValue(radius);
        this.radius = radius;
    }

    //Dragos -> validate double values
    protected void validateNonNegativeValue(Double value) {
        if (value < 0) {
            throw new IllegalArgumentException(Double.toString(value));
        }
    }

    //Dragos validate integer values
    protected void validateNonNegativeValue(Integer value) {
        if (value < 0) {
            throw new IllegalArgumentException(Double.toString(value));
        }
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
    private void validateId(Long id) {
        if (id < 0) {
            throw new IllegalArgumentException(Double.toString(id));
        }
    }

    //Dragos -> validate strings
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
}
