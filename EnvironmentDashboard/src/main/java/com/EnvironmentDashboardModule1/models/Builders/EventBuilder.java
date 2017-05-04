package com.EnvironmentDashboardModule1.models.Builders;

import com.EnvironmentDashboardModule1.models.Events.Event;
import com.EnvironmentDashboardModule1.models.Events.Tornado;

import java.util.Date;

/**
 * Created by Ariana on 5/3/2017.
 */
public class EventBuilder {

    protected String name;

    protected Double latitude;

    protected Double longitude;

    protected Date startingTime;

    protected Date endingTime;

    protected String severity;

    protected String description;

    protected String hints;

    protected Double radius;

    public EventBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public EventBuilder setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public EventBuilder setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public EventBuilder setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
        return this;
    }

    public EventBuilder setEndingTime(Date endingTime) {
        this.endingTime = endingTime;
        return this;
    }

    public EventBuilder setSeverity(String severity) {
        this.severity = severity;
        return this;
    }

    public EventBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public EventBuilder setHints(String hints) {
        this.hints = hints;
        return this;
    }

    public EventBuilder setRadius(Double radius) {
        this.radius = radius;
        return this;
    }

    public Event getEvent(){
        Event event = new Event();

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
}
