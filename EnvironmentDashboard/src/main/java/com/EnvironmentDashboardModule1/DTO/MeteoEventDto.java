package com.EnvironmentDashboardModule1.DTO;

import com.EnvironmentDashboardModule1.DTO.Interfaces.MeteoEventInterface.IHumidity;
import com.EnvironmentDashboardModule1.DTO.Interfaces.MeteoEventInterface.*;
import com.EnvironmentDashboardModule1.DTO.Interfaces.MeteoEventInterface.IPrecipitationLevel;
import com.EnvironmentDashboardModule1.DTO.Interfaces.MeteoEventInterface.ITemperature;
import javafx.util.Builder;

import java.util.Date;

/**
 * Created by Ariana on 5/13/2017.
 */
public class MeteoEventDto extends CreatingMeteoEventDto{
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    protected MeteoEventDto() {};

    public static class Builder implements IUserId, IId, IName, IDescription, IEndingDate, IHints, IRadius, ISeverity, IStartingDate, ILatitude, ILongitude,ITemperature, IHumidity, IPrecipitationLevel {
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

        @Override
        public IRadius hints(String hints) {
            meteoEventDto.hints=hints;
            return this;
        }

        @Override
        public ILatitude name(String name) {
            meteoEventDto.name=name;
            return this;
        }

        @Override
        public IHints description(String description) {
            meteoEventDto.description=description;
            return this;
        }

        @Override
        public ILongitude latitude(Double latitude) {
            meteoEventDto.latitude=latitude;
            return this;
        }

        @Override
        public IDescription severity(String severity) {
            meteoEventDto.severity=severity;
            return this;
        }

        @Override
        public IStartingDate longitude(Double longitude) {
            meteoEventDto.longitude=longitude;
            return this;
        }

        @Override
        public ISeverity endingDate(Date endingDate) {
            meteoEventDto.endingDate=endingDate;
            return this;
        }

        @Override
        public IEndingDate startingDate(Date startingDate) {
            meteoEventDto.startingDate=startingDate;
            return this;
        }

        @Override
        public IPrecipitationLevel radius(Double radius) {
            meteoEventDto.radius=radius;
            return this;
        }

        @Override
        public IName id(Long id) {
            meteoEventDto.id = id;
            return this;
        }

        @Override
        public IId userId(String userId) {
            meteoEventDto.userId = userId;
            return this;
        }
    }
}
