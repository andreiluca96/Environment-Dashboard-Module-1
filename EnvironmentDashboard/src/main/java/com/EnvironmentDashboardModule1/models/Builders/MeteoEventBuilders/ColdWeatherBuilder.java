package com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders;

import com.EnvironmentDashboardModule1.models.MeteoEvents.ColdWeather;

import java.util.Date;

/**
 * Created by Radu Lungu on 5/13/2017.
 */


public class ColdWeatherBuilder extends MeteoEventBuilder{

    private Integer temperature;

    private Integer humidity;

    private Integer precipitationLevel;

    public ColdWeatherBuilder setName(String name) {
        validateString(name);
        this.name = name;
        return this;
    }

    public ColdWeatherBuilder setLatitude(Double latitude) {
        validateLatitude(latitude);
        this.latitude = latitude;
        return this;
    }

    public ColdWeatherBuilder setLongitude(Double longitude) {
        validateLongitude(longitude);
        this.longitude = longitude;
        return this;
    }

    public ColdWeatherBuilder setStartingTime(Date startingTime) {
        validateTime(startingTime);
        this.startingTime = startingTime;
        return this;
    }

    public ColdWeatherBuilder setEndingTime(Date endingTime) {
        validateTime(endingTime);
        this.endingTime = endingTime;
        return this;
    }

    public ColdWeatherBuilder setSeverity(String severity) {
        validateSeverity(severity);
        this.severity = severity;
        return this;
    }

    public ColdWeatherBuilder setDescription(String description) {
        validateString(description);
        this.description = description;
        return this;
    }

    public ColdWeatherBuilder setHints(String hints) {
        validateString(hints);
        this.hints = hints;
        return this;
    }

    public ColdWeatherBuilder setRadius(Double radius) {
        validateNonNegativeValue(radius);
        this.radius = radius;
        return this;
    }

    public ColdWeatherBuilder setTemperature(Integer temperature) {
        this.temperature = temperature;
        return this;
    }

    public ColdWeatherBuilder setHumidity(Integer humidity) {
        validateNonNegativeValue(humidity);
        this.humidity = humidity;
        return this;
    }

    public ColdWeatherBuilder setPrecipitationLevel(Integer precipitationLevel) {
        validateNonNegativeValue(precipitationLevel);
        this.precipitationLevel = precipitationLevel;
        return this;
    }

    public ColdWeatherBuilder setUserId(String userId) {
        this.userId = userId;

        return this;
    }


    public ColdWeather getColdWeather() {
        ColdWeather coldWeather=new ColdWeather();

        coldWeather.setUserId(userId);
        coldWeather.setLatitude(latitude);
        coldWeather.setLongitude(longitude);
        coldWeather.setDescription(description);
        coldWeather.setEndingTime(endingTime);
        coldWeather.setHints(hints);
        coldWeather.setName(name);
        coldWeather.setRadius(radius);
        coldWeather.setSeverity(severity);
        coldWeather.setStartingTime(startingTime);
        coldWeather.setHumidity(humidity);
        coldWeather.setPrecipitationLevel(precipitationLevel);
        coldWeather.setTemperature(temperature);
        return coldWeather;
    }

    
    protected void validateNonNegativeValue(Integer value) {
        if (value < 0) {
            throw new IllegalArgumentException(Integer.toString(value));
        }
    }
}