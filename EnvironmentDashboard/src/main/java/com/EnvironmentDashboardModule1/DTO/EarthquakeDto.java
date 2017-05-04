package com.EnvironmentDashboardModule1.DTO;

import com.EnvironmentDashboardModule1.DTO.Interfaces.Earthquake.*;

import java.util.Date;


/**
 * Created by Luca Andrei on 5/4/2017.
 */
public class EarthquakeDto extends CreatingEarthquakeDto {
    private Long id;

    private EarthquakeDto() { super(); };

    public static class Builder implements IDepth, IDescription, IEndingDate, IHints, ILatitude, ILongitude, IMercaliDegree, IRadius, IRichterDegree, ISeverity, IStartingDate {
        private EarthquakeDto earthquakeDto = new EarthquakeDto();

        @Override
        public IRadius hints(String hints) {
            earthquakeDto.hints = hints;
            return this;
        }

        @Override
        public IHints description(String description) {
            earthquakeDto.description = description;
            return this;
        }

        @Override
        public ILongitude latitude(Double latitude) {
            earthquakeDto.latitude = latitude;
            return this;
        }

        @Override
        public IDepth richterDegree(Double richterDegree) {
            earthquakeDto.richterDegree = richterDegree;
            return this;
        }

        @Override
        public IDescription severity(String severity) {
            earthquakeDto.severity = severity;
            return this;
        }

        @Override
        public IStartingDate longitude(Double longitude) {
            earthquakeDto.longitude = longitude;
            return this;
        }

        @Override
        public IRichterDegree mercaliDegree(Double mercaliDegree) {
            earthquakeDto.mercaliDegree = mercaliDegree;
            return this;
        }

        @Override
        public ISeverity endingDate(Date endingDate) {
            earthquakeDto.endingDate = endingDate;
            return this;
        }

        @Override
        public IEndingDate startingDate(Date startingDate) {
            earthquakeDto.startingDate = startingDate;
            return this;
        }

        @Override
        public IMercaliDegree radius(Double radius) {
            earthquakeDto.radius = radius;
            return this;
        }

        @Override
        public EarthquakeDto depth(Integer depth) {
            earthquakeDto.depth = depth;
            return earthquakeDto;
        }
    }
}
