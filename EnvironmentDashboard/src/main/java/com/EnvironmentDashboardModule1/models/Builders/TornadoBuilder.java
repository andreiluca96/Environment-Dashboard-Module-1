package com.EnvironmentDashboardModule1.models.Builders;

import com.EnvironmentDashboardModule1.models.Events.Tornado;

import java.util.Date;

/**
 * Created by Luca Andrei on 5/4/2017.
 */
public class TornadoBuilder extends EventBuilder {

    private Double windspeed;

    private String name;

    private Double latitude;

    private Double longitude;

    private Date startingTime;

    private Date endingTime;

    private String severity;

    private String description;

    private String hints;

    private Double radius;

    public TornadoBuilder setName(String name) {
        validateName(name);
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
        validateName(description);
        this.description = description;
        return this;
    }

    public TornadoBuilder setHints(String hints) {
        validateName(hints);
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
    private void validateName(String name) {
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

    //Dragos -> validate radius
    private void validateNonNegativeValue(Double value) {
        if (value < 0) {
            throw new IllegalArgumentException(Double.toString(value));
        }
    }
}
