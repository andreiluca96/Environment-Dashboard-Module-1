package com.EnvironmentDashboardModule1.DTO;

import com.EnvironmentDashboardModule1.DTO.Interfaces.TsunamiInterfaces.*;

import java.util.Date;

/**
 * Created by Ariana on 5/12/2017.
 */
public class TsunamiDto extends CreatingTsunamiDto {
    private Long id;

    private TsunamiDto() { super(); }

    public static class Builder implements IMaxWaveHeight, IName, IDescription, IEndingDate, IHints, IRadius, ISeverity, IStartingDate, ILatitude, ILongitude {
        private TsunamiDto tsunamiDto = new TsunamiDto();

        @Override
        public IRadius hints(String hints) {
            tsunamiDto.hints = hints;
            return this;
        }

        @Override
        public IHints description(String description) {
            tsunamiDto.description = description;
            return this;
        }

        @Override
        public ISeverity endingDate(Date endingDate) {
            tsunamiDto.endingDate = endingDate;
            return this;
        }

        @Override
        public IEndingDate startingDate(Date startingDate) {
            tsunamiDto.startingDate = startingDate;
            return this;
        }

        @Override
        public IDescription severity(String severity) {
            tsunamiDto.severity = severity;
            return this;
        }

        @Override
        public IStartingDate longitude(Double longitude) {
            tsunamiDto.longitude = longitude;
            return this;
        }

        @Override
        public ILongitude latitude(Double latitude) {
            tsunamiDto.latitude = latitude;
            return this;
        }

        @Override
        public ILatitude name(String name) {
            tsunamiDto.name = name;
            return this;
        }

        @Override
        public TsunamiDto maxWaveWeight(Double maxWaveWeight) {
            tsunamiDto.maxWaveHeight = maxWaveWeight;
            return tsunamiDto;
        }

        @Override
        public IMaxWaveHeight radius(Double radius) {
            tsunamiDto.radius = radius;
            return this;
        }
    }
}

