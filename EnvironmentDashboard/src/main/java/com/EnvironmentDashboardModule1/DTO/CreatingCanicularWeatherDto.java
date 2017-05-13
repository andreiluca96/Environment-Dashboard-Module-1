package com.EnvironmentDashboardModule1.DTO;

/**
 * Created by Radu Lungu on 5/13/2017.
 */
public class CreatingCanicularWeatherDto extends CreatingMeteoEventDto {
    protected Integer temperature;
    protected Integer humidity;
    protected Integer precipitationLevel;

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getPrecipitationLevel() {
        return precipitationLevel;
    }

    public void setPrecipitationLevel(Integer precipitationLevel) {
        this.precipitationLevel = precipitationLevel;
    }

}