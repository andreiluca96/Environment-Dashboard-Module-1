package com.EnvironmentDashboardModule1.models;

/**
 * Created by Ariana on 5/3/2017.
 */
public class MeteoBuilder {

    private Integer temperature;

    private Integer humidity;

    private Integer precipitationLevel;


    public MeteoBuilder setTemperature(Integer temperature) {
        this.temperature = temperature;
        return this;
    }

    public MeteoBuilder setHumidity(Integer humidity) {
        this.humidity = humidity;
        return this;
    }

    public MeteoBuilder setPrecipitationLevel(Integer precipitationLevel) {
        this.precipitationLevel = precipitationLevel;
        return this;
    }

    public MeteoEvent getMeteoEvent() {
        MeteoEvent meteoEvent=new MeteoEvent();
        meteoEvent.setHumidity(humidity);
        meteoEvent.setPrecipitationLevel(precipitationLevel);
        meteoEvent.setTemperature(temperature);
        return meteoEvent;
    }
}
