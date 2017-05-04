package com.EnvironmentDashboardModule1.DTO;

import com.EnvironmentDashboardModule1.DTO.CreatingEventDto;

/**
 * Created by Luca Andrei on 5/4/2017.
 */
public class CreatingTornadoDto extends CreatingEventDto {
    protected Double windspeed;

    public Double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(Double windspeed) {
        this.windspeed = windspeed;
    }
}
