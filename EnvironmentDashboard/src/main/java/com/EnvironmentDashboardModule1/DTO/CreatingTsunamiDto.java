package com.EnvironmentDashboardModule1.DTO;

/**
 * Created by Ariana on 5/12/2017.
 */
public class CreatingTsunamiDto extends CreatingEventDto {
    protected Double maxWaveHeight;

    public Double getMaxWaveHeight() {
        return maxWaveHeight;
    }

    public void setMaxWaveHeight(Double maxWaveHeight) {
        this.maxWaveHeight = maxWaveHeight;
    }
}
