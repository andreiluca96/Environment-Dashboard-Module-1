package com.EnvironmentDashboardModule1.models.Builders.EventBuilders;

import com.EnvironmentDashboardModule1.models.Events.Event;
import com.EnvironmentDashboardModule1.models.Severity;

import java.util.Date;

/**
 * Created by Ariana on 5/3/2017.
 */

/**
 * For the creation of objects, we used the Builder Creational Pattern. This is the parent class for the other events
 * and is also extended by their classes: earthquake, fire, flood etc. Furthermore, it includes validations for
 * attributes which will help the unit tests work properly.
 */
public class EventBuilder {

    protected String name;

    protected Double latitude;

    protected Double longitude;

    protected Date startingTime;

    protected Date endingTime;

    protected Severity severity;

    protected String description;

    protected String hints;

    protected Double radius;

    protected String userId;

    public EventBuilder setUserId(String userId) {
        validateString(userId);
        this.userId = userId;
        return this;
    }

    public EventBuilder setName(String name) {
        validateString(name);
        this.name = name;
        return this;
    }

    public EventBuilder setLatitude(Double latitude) {
        validateLatitude(latitude);
        this.latitude = latitude;
        return this;
    }

    public EventBuilder setLongitude(Double longitude) {
        validateLongitude(longitude);
        this.longitude = longitude;
        return this;
    }

    public EventBuilder setStartingTime(Date startingTime) {
        validateTime(startingTime);
        this.startingTime = startingTime;
        return this;
    }

    public EventBuilder setEndingTime(Date endingTime) {
        validateTime(endingTime);
        this.endingTime = endingTime;
        return this;
    }

    public EventBuilder setSeverity(Severity severity) {
        this.severity = severity;
        return this;
    }

    public EventBuilder setDescription(String description) {
        validateString(description);
        this.description = description;
        return this;
    }

    public EventBuilder setHints(String hints) {
        validateString(hints);
        this.hints = hints;
        return this;
    }

    public EventBuilder setRadius(Double radius) {
        validateNonNegativeValue(radius);
        this.radius = radius;
        return this;
    }

    public Event getEvent(){
        Event event = new Event();

        event.setUserId(userId);
        event.setLatitude(latitude);
        event.setLongitude(longitude);
        event.setDescription(description);
        event.setEndingTime(endingTime);
        event.setHints(hints);
        event.setName(name);
        event.setRadius(radius);
        event.setSeverity(severity);
        event.setStartingTime(startingTime);

        return event;
    }


    //Dragos -> validate latitude
    protected void validateLatitude(Double latitude) {
        if (latitude < -85 || latitude > 85) {
            throw new IllegalArgumentException(Double.toString(latitude));
        }
    }

    //Dragos -> validate longitude
    protected void validateLongitude(Double longitude) {
        if (longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException(Double.toString(longitude));
        }
    }

    //Dragos -> validate non-negative integer
    protected void validateNonNegativeValue(Integer value) {
        if (value < 0) {
            throw new IllegalArgumentException(Double.toString(value));
        }
    }

    //Dragos -> validate name
    protected void validateString(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Null string");
        }
    }

    //Dragos -> validate time
    protected void validateTime(Date time) {
        if (time == null) {
            throw new IllegalArgumentException("Null time");
        }
    }

    //Dragos -> validate non-negative double
    protected void validateNonNegativeValue(Double value) {
        if (value < 0) {
            throw new IllegalArgumentException(Double.toString(value));
        }
    }
}
