package com.EnvironmentDashboardModule1.models.Builders;

import com.EnvironmentDashboardModule1.models.Events.Tornado;

import java.util.Date;

/**
 * Created by Luca Andrei on 5/4/2017.
 */
public class TornadoBuilder extends EventBuilder {

    private Double windspeed;

    public TornadoBuilder setWindspeed(Double windspeed) {
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
