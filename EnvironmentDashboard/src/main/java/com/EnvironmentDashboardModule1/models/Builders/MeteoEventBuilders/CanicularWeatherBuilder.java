package com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders;

import com.EnvironmentDashboardModule1.models.MeteoEvents.CanicularWeather;

import java.util.Date;

/**
 * Created by Radu Lungu on 5/13/2017.
 */


public class CanicularWeatherBuilder extends MeteoEventBuilder{

    private Integer temperature;

    private Integer humidity;

    private Integer precipitationLevel;

    public CanicularWeatherBuilder setName(String name) {
        validateString(name);
        this.name = name;
        return this;
    }

    public CanicularWeatherBuilder setLatitude(Double latitude) {
        validateLatitude(latitude);
        this.latitude = latitude;
        return this;
    }

    public CanicularWeatherBuilder setLongitude(Double longitude) {
        validateLongitude(longitude);
        this.longitude = longitude;
        return this;
    }

    public CanicularWeatherBuilder setStartingTime(Date startingTime) {
        validateTime(startingTime);
        this.startingTime = startingTime;
        return this;
    }

    public CanicularWeatherBuilder setEndingTime(Date endingTime) {
        validateTime(endingTime);
        this.endingTime = endingTime;
        return this;
    }

    public CanicularWeatherBuilder setSeverity(String severity) {
        validateSeverity(severity);
        this.severity = severity;
        return this;
    }

    public CanicularWeatherBuilder setDescription(String description) {
        validateString(description);
        this.description = description;
        return this;
    }

    public CanicularWeatherBuilder setHints(String hints) {
        validateString(hints);
        this.hints = hints;
        return this;
    }

    public CanicularWeatherBuilder setRadius(Double radius) {
        validateNonNegativeValue(radius);
        this.radius = radius;
        return this;
    }

    public CanicularWeatherBuilder setTemperature(Integer temperature) {
        this.temperature = temperature;
        return this;
    }

    public CanicularWeatherBuilder setHumidity(Integer humidity) {
        validateNonNegativeValue(humidity);
        this.humidity = humidity;
        return this;
    }

    public CanicularWeatherBuilder setPrecipitationLevel(Integer precipitationLevel) {
        validateNonNegativeValue(precipitationLevel);
        this.precipitationLevel = precipitationLevel;
        return this;
    }


    public CanicularWeather getCanicularWeather() {
        CanicularWeather canicularWeather=new CanicularWeather();
        canicularWeather.setLatitude(latitude);
        canicularWeather.setLongitude(longitude);
        canicularWeather.setDescription(description);
        canicularWeather.setEndingTime(endingTime);
        canicularWeather.setHints(hints);
        canicularWeather.setName(name);
        canicularWeather.setRadius(radius);
        canicularWeather.setSeverity(severity);
        canicularWeather.setStartingTime(startingTime);
        canicularWeather.setHumidity(humidity);
        canicularWeather.setPrecipitationLevel(precipitationLevel);
        canicularWeather.setTemperature(temperature);
        return canicularWeather;
    }

    
    protected void validateNonNegativeValue(Integer value) {
        if (value < 0) {
            throw new IllegalArgumentException(Integer.toString(value));
        }
    }
}