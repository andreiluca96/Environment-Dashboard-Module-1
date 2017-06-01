package com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders;

import com.EnvironmentDashboardModule1.models.Builders.EventBuilders.EventBuilder;
import com.EnvironmentDashboardModule1.models.MeteoEvents.MeteoEvent;
import com.EnvironmentDashboardModule1.models.Severity;

import java.util.Date;

/**
 * Created by Ariana on 5/3/2017.
 */

/**
 * For the creation of objects, we used the Builder Creational Pattern. This is the parent class for the other meteo
 * events and is also extended by their classes: fog, rain, snow etc. Furthermore, it includes validations for
 * attributes which will help unit tests work properly.
 */
//Dragos -> refactorization: renamed from MeteoBuilder to MeteoEventBuilder
public class MeteoEventBuilder extends EventBuilder{

    //Dragos -> refactorization: made members protected, so they can be inherited
    protected Integer temperature;

    protected Integer humidity;

    protected Integer precipitationLevel;

    public MeteoEventBuilder setName(String name) {
        validateString(name);
        this.name = name;
        return this;
    }

    public MeteoEventBuilder setLatitude(Double latitude) {
        validateLatitude(latitude);
        this.latitude = latitude;
        return this;
    }

    public MeteoEventBuilder setLongitude(Double longitude) {
        validateLongitude(longitude);
        this.longitude = longitude;
        return this;
    }

    public MeteoEventBuilder setStartingTime(Date startingTime) {
        validateTime(startingTime);
        this.startingTime = startingTime;
        return this;
    }

    public MeteoEventBuilder setEndingTime(Date endingTime) {
        validateTime(endingTime);
        this.endingTime = endingTime;
        return this;
    }

    public MeteoEventBuilder setSeverity(Severity severity) {
        this.severity = severity;
        return this;
    }

    public MeteoEventBuilder setDescription(String description) {
        validateString(description);
        this.description = description;
        return this;
    }

    public MeteoEventBuilder setHints(String hints) {
        validateString(hints);
        this.hints = hints;
        return this;
    }

    public MeteoEventBuilder setRadius(Double radius) {
        validateNonNegativeValue(radius);
        this.radius = radius;
        return this;
    }

    public MeteoEventBuilder setTemperature(Integer temperature) {
        validateTemperature(temperature);
        this.temperature = temperature;
        return this;
    }

    public MeteoEventBuilder setHumidity(Integer humidity) {
        validateNonNegativeValue(humidity);
        this.humidity = humidity;
        return this;
    }

    public MeteoEventBuilder setPrecipitationLevel(Integer precipitationLevel) {
        validateNonNegativeValue(precipitationLevel);
        this.precipitationLevel = precipitationLevel;
        return this;
    }

    public MeteoEventBuilder setUserId(String userId) {
        validateString(userId);
        this.userId = userId;
        return this;
    }

    public MeteoEvent getMeteoEvent() {
        MeteoEvent meteoEvent=new MeteoEvent();

        meteoEvent.setUserId(userId);
        meteoEvent.setLatitude(latitude);
        meteoEvent.setLongitude(longitude);
        meteoEvent.setDescription(description);
        meteoEvent.setEndingTime(endingTime);
        meteoEvent.setHints(hints);
        meteoEvent.setName(name);
        meteoEvent.setRadius(radius);
        meteoEvent.setSeverity(severity);
        meteoEvent.setStartingTime(startingTime);
        meteoEvent.setHumidity(humidity);
        meteoEvent.setPrecipitationLevel(precipitationLevel);
        meteoEvent.setTemperature(temperature);
        return meteoEvent;
    }

    //Dragos -> validate temperature, integer values between -100 and +100
    protected void validateTemperature(Integer temperature){
        if(temperature < -100 || temperature > 100){
            throw new IllegalArgumentException(Integer.toString(temperature));
        }
    }
}
