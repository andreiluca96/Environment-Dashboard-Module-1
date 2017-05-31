package com.EnvironmentDashboardModule1.DTO;


import com.EnvironmentDashboardModule1.DTO.Interfaces.ColdWeatherInterfaces.*;


import java.util.Date;

/**
 * Created by Radu Lungu on 5/13/2017.
 */
public class ColdWeatherDto extends CreatingMeteoEventDto{
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    protected ColdWeatherDto() {};

    public static class Builder implements IUserId, IId, IName, IDescription, IEndingDate, IHints, IRadius, ISeverity, IStartingDate, ILatitude, ILongitude,ITemperature, IHumidity, IPrecipitationLevel {
        private ColdWeatherDto coldWeatherDto = new ColdWeatherDto();


        @Override
        public IHumidity temperature(Integer temperature) {
            coldWeatherDto.temperature=temperature;
            return this;
        }

        @Override
        public ColdWeatherDto humidity(Integer humidity) {

            coldWeatherDto.humidity=humidity;
            return coldWeatherDto;
        }

        @Override
        public ITemperature precipitationLevel(Integer precipitationLevel) {

            coldWeatherDto.precipitationLevel=precipitationLevel;
            return this;
        }

        @Override
        public IRadius hints(String hints) {
            coldWeatherDto.hints=hints;
            return this;
        }

        @Override
        public ILatitude name(String name) {
            coldWeatherDto.name=name;
            return this;
        }

        @Override
        public IHints description(String description) {
            coldWeatherDto.description=description;
            return this;
        }

        @Override
        public ILongitude latitude(Double latitude) {
            coldWeatherDto.latitude=latitude;
            return this;
        }

        @Override
        public IDescription severity(String severity) {
            coldWeatherDto.severity=severity;
            return this;
        }

        @Override
        public IStartingDate longitude(Double longitude) {
            coldWeatherDto.longitude=longitude;
            return this;
        }

        @Override
        public ISeverity endingDate(Date endingDate) {
            coldWeatherDto.endingDate=endingDate;
            return this;
        }

        @Override
        public IEndingDate startingDate(Date startingDate) {
            coldWeatherDto.startingDate=startingDate;
            return this;
        }

        @Override
        public IPrecipitationLevel radius(Double radius) {
            coldWeatherDto.radius=radius;
            return this;
        }

        @Override
        public IName id(Long id) {
            coldWeatherDto.id = id;
            return this;
        }

        @Override
        public IId userId(String userId) {
            coldWeatherDto.userId = userId;
            return this;
        }
    }
}