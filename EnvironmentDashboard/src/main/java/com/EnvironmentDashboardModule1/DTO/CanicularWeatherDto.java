package com.EnvironmentDashboardModule1.DTO;


import com.EnvironmentDashboardModule1.DTO.Interfaces.CanicularWeatherInterfaces.*;


import java.util.Date;

/**
 * Created by Radu Lungu on 5/13/2017.
 */
public class CanicularWeatherDto extends CreatingMeteoEventDto{
    private Long id;

    protected CanicularWeatherDto() {};

    public static class Builder implements IName, IDescription, IEndingDate, IHints, IRadius, ISeverity, IStartingDate, ILatitude, ILongitude,ITemperature, IHumidity, IPrecipitationLevel {
        private CanicularWeatherDto canicularWeatherDto = new CanicularWeatherDto();


        @Override
        public IHumidity temperature(Integer temperature) {
            canicularWeatherDto.temperature=temperature;
            return this;
        }

        @Override
        public CanicularWeatherDto humidity(Integer humidity) {

            canicularWeatherDto.humidity=humidity;
            return canicularWeatherDto;
        }

        @Override
        public ITemperature precipitationLevel(Integer precipitationLevel) {

            canicularWeatherDto.precipitationLevel=precipitationLevel;
            return this;
        }

        @Override
        public IRadius hints(String hints) {
            canicularWeatherDto.hints=hints;
            return this;
        }

        @Override
        public ILatitude name(String name) {
            canicularWeatherDto.name=name;
            return this;
        }

        @Override
        public IHints description(String description) {
            canicularWeatherDto.description=description;
            return this;
        }

        @Override
        public ILongitude latitude(Double latitude) {
            canicularWeatherDto.latitude=latitude;
            return this;
        }

        @Override
        public IDescription severity(String severity) {
            canicularWeatherDto.severity=severity;
            return this;
        }

        @Override
        public IStartingDate longitude(Double longitude) {
            canicularWeatherDto.longitude=longitude;
            return this;
        }

        @Override
        public ISeverity endingDate(Date endingDate) {
            canicularWeatherDto.endingDate=endingDate;
            return this;
        }

        @Override
        public IEndingDate startingDate(Date startingDate) {
            canicularWeatherDto.startingDate=startingDate;
            return this;
        }

        @Override
        public IPrecipitationLevel radius(Double radius) {
            canicularWeatherDto.radius=radius;
            return this;
        }
    }
}