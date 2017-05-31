package com.EnvironmentDashboardModule1.DTO;

import com.EnvironmentDashboardModule1.DTO.Interfaces.FloodInterfaces.*;
import com.EnvironmentDashboardModule1.models.Severity;

import java.util.Date;

/**
 * Created by Sabina on 5/8/2017.
 */
public class FloodDto extends CreatingFloodDto {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private FloodDto() {
        super();
    };

    public static class Builder implements IUserId, IId, IName, IDescription, IEndingDate, IHints, IRadius, ISeverity, IStartingDate, ILatitude, ILongitude,IPrecipitationLevel {
        private FloodDto floodDto = new FloodDto();

        @Override
        public IRadius hints(String hints) {
            floodDto.hints=hints;
            return this;
        }

        @Override
        public ILatitude name(String name) {
            floodDto.name=name;
            return this;
        }

        @Override
        public IPrecipitationLevel radius(Double radius) {
            floodDto.radius=radius;
            return this;
        }

        @Override
        public IHints description(String description) {
            floodDto.description=description;
            return this;
        }

        @Override
        public ILongitude latitude(Double latitude) {
            floodDto.latitude=latitude;
            return this;
        }

        @Override
        public IDescription severity(Severity severity) {
            floodDto.severity=severity;
            return this;
        }

        @Override
        public IStartingDate longitude(Double longitude) {
            floodDto.longitude=longitude;
            return this;
        }

        @Override
        public ISeverity endingDate(Date endingDate) {
            floodDto.endingDate=endingDate;
            return this;
        }

        @Override
        public IEndingDate startingDate(Date startingDate) {
            floodDto.startingDate=startingDate;
            return this;
        }

        @Override
        public FloodDto precipitationLevel(Double precipitationLevel) {
            floodDto.precipitationLevel=precipitationLevel;
            return floodDto;
        }

        @Override
        public IName id(Long id) {
            floodDto.id = id;
            return this;
        }

        @Override
        public IId userId(String userId) {
            floodDto.userId = userId;
            return this;
        }
    }
}

