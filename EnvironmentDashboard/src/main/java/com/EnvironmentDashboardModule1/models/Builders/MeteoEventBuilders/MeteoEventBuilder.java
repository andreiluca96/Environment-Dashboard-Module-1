package com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders;

import com.EnvironmentDashboardModule1.models.MeteoEvents.MeteoEvent;

/**
 * Created by Ariana on 5/3/2017.
 */

//Dragos -> refactorization: renamed from MeteoBuilder to MeteoEventBuilder
public class MeteoEventBuilder {

    private Integer temperature;

    private Integer humidity;

    private Integer precipitationLevel;


    public MeteoEventBuilder setTemperature(Integer temperature) {
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


    public MeteoEvent getMeteoEvent() {
        MeteoEvent meteoEvent=new MeteoEvent();
        meteoEvent.setHumidity(humidity);
        meteoEvent.setPrecipitationLevel(precipitationLevel);
        meteoEvent.setTemperature(temperature);
        return meteoEvent;
    }

    //Dragos -> validate integer values
    protected void validateNonNegativeValue(Integer value) {
        if (value < 0) {
            throw new IllegalArgumentException(Integer.toString(value));
        }
    }
}
