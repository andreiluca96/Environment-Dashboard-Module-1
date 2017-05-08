package com.EnvironmentDashboardModule1.DTO;

/**
 * Created by Sabina on 5/8/2017.
 */
public class CreatingFloodDto extends CreatingEventDto {

    protected Double precipitationLevel;

    public Double getPrecipitationLevel() {
        return precipitationLevel;
    }

    public void setPrecipitationLevel(Double precipitationLevel) {
        this.precipitationLevel = precipitationLevel;
    }
}
