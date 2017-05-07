package com.EnvironmentDashboardModule1.models.Builders;

import com.EnvironmentDashboardModule1.models.Events.Tornado;

import java.util.Date;

/**
 * Created by Luca Andrei on 5/4/2017.
 */

public class TornadoBuilder extends EventBuilder {

    private Double windspeed;

    public TornadoBuilder setName(String name) {
        validateString(name);
        this.name = name;
        return this;
    }

    public TornadoBuilder setLatitude(Double latitude) {
        validateLatitude(latitude);
        this.latitude = latitude;
        return this;
    }

    public TornadoBuilder setLongitude(Double longitude) {
        validateLongitude(longitude);
        this.longitude = longitude;
        return this;
    }

    public TornadoBuilder setStartingTime(Date startingTime) {
        validateTime(startingTime);
        this.startingTime = startingTime;
        return this;
    }

    public TornadoBuilder setEndingTime(Date endingTime) {
        validateTime(endingTime);
        this.endingTime = endingTime;
        return this;
    }

    public TornadoBuilder setSeverity(String severity) {
        validateSeverity(severity);
        this.severity = severity;
        return this;
    }

    public TornadoBuilder setDescription(String description) {
        validateString(description);
        this.description = description;
        return this;
    }

    public TornadoBuilder setHints(String hints) {
        validateString(hints);
        this.hints = hints;
        return this;
    }

    public TornadoBuilder setRadius(Double radius) {
        validateNonNegativeValue(radius);
        this.radius = radius;
        return this;
    }
    
    public TornadoBuilder setWindspeed(Double windspeed) {
        validateNonNegativeValue(windspeed);
        this.windspeed = windspeed;
        return this;
    }

    public Tornado getTornado(){
        Tornado tornado = new Tornado();

        tornado.setLatitude(latitude);
        tornado.setLongitude(longitude);
        tornado.setDescription(description);
        tornado.setEndingTime(endingTime);
        tornado.setHints(hints);
        tornado.setName(name);
        tornado.setRadius(radius);
        tornado.setSeverity(severity);
        tornado.setStartingTime(startingTime);
        tornado.setWindSpeed(windspeed);

        return tornado;
    }

}
