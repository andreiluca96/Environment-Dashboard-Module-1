package com.EnvironmentDashboardModule1.DTO;

import com.EnvironmentDashboardModule1.DTO.Interfaces.TornadoInterfaces.*;


import java.util.Date;

/**
 * Created by Luca Andrei on 5/4/2017.
 */
public class TornadoDto extends CreatingTornadoDto {
    private Long id;

    private TornadoDto() { super(); }

    public static class Builder implements IId, IWindspeed, IName, IDescription, IEndingDate, IHints, IRadius, ISeverity, IStartingDate, ILatitude, ILongitude {
        private TornadoDto tornadoDto = new TornadoDto();

        @Override
        public IRadius hints(String hints) {
            tornadoDto.hints = hints;
            return this;
        }

        @Override
        public IHints description(String description) {
            tornadoDto.description = description;
            return this;
        }

        @Override
        public ISeverity endingDate(Date endingDate) {
            tornadoDto.endingDate = endingDate;
            return this;
        }

        @Override
        public IEndingDate startingDate(Date startingDate) {
            tornadoDto.startingDate = startingDate;
            return this;
        }

        @Override
        public IWindspeed radius(Double radius) {
            tornadoDto.radius = radius;
            return this;
        }

        @Override
        public IDescription severity(String severity) {
            tornadoDto.severity = severity;
            return this;
        }

        @Override
        public IStartingDate longitude(Double longitude) {
            tornadoDto.longitude = longitude;
            return this;
        }

        @Override
        public ILongitude latitude(Double latitude) {
            tornadoDto.latitude = latitude;
            return this;
        }

        @Override
        public ILatitude name(String name) {
            tornadoDto.name = name;
            return this;
        }

        @Override
        public TornadoDto windspeed(Double windspeed) {
            tornadoDto.windspeed = windspeed;
            return tornadoDto;
        }

        @Override
        public IName id(Long id) {
            tornadoDto.id = id;
            return this;
        }
    }
}
