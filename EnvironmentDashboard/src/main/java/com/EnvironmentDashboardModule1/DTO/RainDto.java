package com.EnvironmentDashboardModule1.DTO;


import com.EnvironmentDashboardModule1.DTO.Interfaces.RainInterfaces.*;


import java.util.Date;

/**
 * Created by Andrei Sfarghiu on 5/13/2017.
 */
public class RainDto extends CreatingRainDto{
        private Long id;

    protected RainDto() {};

    public static class Builder implements IName, IDescription, IEndingDate, IHints, IRadius, ISeverity, IStartingDate, ILatitude, ILongitude,ITemperature, IHumidity, IPrecipitationLevel {
        private RainDto rainDto = new RainDto();


        @Override
        public IHumidity temperature(Integer temperature) {
            rainDto.temperature=temperature;
            return this;
        }

        @Override
        public RainDto humidity(Integer humidity) {

            rainDto.humidity=humidity;
            return rainDto;
        }

        @Override
        public ITemperature precipitationLevel(Integer precipitationLevel) {

            rainDto.precipitationLevel=precipitationLevel;
            return this;
        }

        @Override
        public IRadius hints(String hints) {
            rainDto.hints=hints;
            return this;
        }

        @Override
        public ILatitude name(String name) {
            rainDto.name=name;
            return this;
        }

        @Override
        public IHints description(String description) {
            rainDto.description=description;
            return this;
        }

        @Override
        public ILongitude latitude(Double latitude) {
            rainDto.latitude=latitude;
            return this;
        }

        @Override
        public IDescription severity(String severity) {
            rainDto.severity=severity;
            return this;
        }

        @Override
        public IStartingDate longitude(Double longitude) {
            rainDto.longitude=longitude;
            return this;
        }

        @Override
        public ISeverity endingDate(Date endingDate) {
            rainDto.endingDate=endingDate;
            return this;
        }

        @Override
        public IEndingDate startingDate(Date startingDate) {
            rainDto.startingDate=startingDate;
            return this;
        }

        @Override
        public IPrecipitationLevel radius(Double radius) {
            rainDto.radius=radius;
            return this;
        }
    }
}