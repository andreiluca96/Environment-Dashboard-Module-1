package com.EnvironmentDashboardModule1.DTO;

import com.EnvironmentDashboardModule1.DTO.Interfaces.FireInterfaces.*;

import java.util.Date;

/**
 * Created by Sabina on 5/8/2017.
 */
public class FireDto extends CreatingFireDto {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private FireDto() {
        super();
    };

    public static class Builder implements IId, ISpeed, IName, IDescription, IEndingDate, IHints, IRadius, ISeverity, IStartingDate, ILatitude, ILongitude {
        private FireDto fireDto = new FireDto();

        @Override
        public IRadius hints(String hints) {
            fireDto.hints=hints;
            return this;
        }

        @Override
        public ILatitude name(String name) {
            fireDto.name=name;
            return this;
        }

        @Override
        public ISpeed radius(Double radius) {
            fireDto.radius=radius;
            return this;
        }

        @Override
        public IHints description(String description) {
            fireDto.description=description;
            return this;
        }

        @Override
        public ILongitude latitude(Double latitude) {
            fireDto.latitude=latitude;
            return this;
        }

        @Override
        public IDescription severity(String severity) {
            fireDto.severity=severity;
            return this;
        }

        @Override
        public IStartingDate longitude(Double longitude) {
            fireDto.longitude=longitude;
            return this;
        }

        @Override
        public ISeverity endingDate(Date endingDate) {
            fireDto.endingDate=endingDate;
            return this;
        }

        @Override
        public IEndingDate startingDate(Date startingDate) {
            fireDto.startingDate=startingDate;
            return this;
        }

        @Override
        public FireDto speed(Double speed) {
            fireDto.speed=speed;
            return fireDto;
        }

        @Override
        public IName id(Long id) {
            fireDto.id = id;
            return this;
        }
    }
}


