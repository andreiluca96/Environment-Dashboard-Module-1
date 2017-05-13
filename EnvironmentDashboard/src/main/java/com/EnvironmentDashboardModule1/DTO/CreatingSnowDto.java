
package com.EnvironmentDashboardModule1.DTO;

/**
 *
 * @author Vladut
 */
public class CreatingSnowDto extends CreatingMeteoEventDto {
    
     public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }
    
    public Integer getPrecipitationLevel() {
        return precipitationLevel;
    }

    public void setPrecipitationLevel(Integer precipitationLevel) {
        this.precipitationLevel = precipitationLevel;
    }

}
