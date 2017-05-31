package com.EnvironmentDashboardModule1.models.Builders.EventBuilders;

import com.EnvironmentDashboardModule1.models.Events.Earthquake;
import com.EnvironmentDashboardModule1.models.Severity;

import java.util.Date;

/**
 * Created by daioanei on 5/4/2017.
 */

public class EarthquakeBuilder extends EventBuilder{

    private Double richterDegree;

    private Double mercalliDegree;

    private Integer depth;


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
