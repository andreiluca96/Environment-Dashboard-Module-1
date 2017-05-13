package com.EnvironmentDashboardModule1.DTO;

import com.EnvironmentDashboardModule1.DTO.Interfaces.MeteoEventInterface.IHumidity;
import com.EnvironmentDashboardModule1.DTO.Interfaces.MeteoEventInterface.IPrecipitationLevel;
import com.EnvironmentDashboardModule1.DTO.Interfaces.MeteoEventInterface.ITemperature;
import javafx.util.Builder;

/**
 * Created by Ariana on 5/13/2017.
 */
public class MeteoEventDto extends CreatingMeteoEventDto{
    private Long id;

    protected MeteoEventDto() {};

    public static class Builder implements ITemperature, IHumidity, IPrecipitationLevel {
        private MeteoEventDto meteoEventDto = new MeteoEventDto();


        @Override
        public IHumidity temperature(Integer temperature) {
            meteoEventDto.temperature=temperature;
            return this;
        }

        @Override
        public MeteoEventDto humidity(Integer humidity) {

            meteoEventDto.humidity=humidity;
            return meteoEventDto;
        }

        @Override
        public ITemperature precipitationLevel(Integer precipitationLevel) {

            meteoEventDto.precipitationLevel=precipitationLevel;
            return this;
        }
    }
}
