package com.EnvironmentDashboardModule1.DTO;

import com.EnvironmentDashboardModule1.DTO.Interfaces.EventInterfaces.*;

import java.util.Date;

/**
 * Created by Luca Andrei on 5/3/2017.
 */
public class EventDto extends CreatingEventDto {
    private Long id;

    protected EventDto() {};

    public static class Builder implements IName, IDescription, IEndingDate, IHints, IRadius, ISeverity, IStartingDate, ILatitude, ILongitude {
        private EventDto eventDto = new EventDto();

        @Override
        public IRadius hints(String hints) {
            eventDto.hints = hints;
            return this;
        }

        @Override
        public IHints description(String description) {
            eventDto.description = description;
            return this;
        }

        @Override
        public ISeverity endingDate(Date endingDate) {
            eventDto.endingDate = endingDate;
            return this;
        }

        @Override
        public IEndingDate startingDate(Date startingDate) {
            eventDto.startingDate = startingDate;
            return this;
        }

        @Override
        public EventDto radius(Double radius) {
            eventDto.radius = radius;
            return eventDto;
        }

        @Override
        public IDescription severity(String severity) {
            eventDto.severity = severity;
            return this;
        }

        @Override
        public IStartingDate longitude(Double longitude) {
            eventDto.longitude = longitude;
            return this;
        }

        @Override
        public ILongitude latitude(Double latitude) {
            eventDto.latitude = latitude;
            return this;
        }

        @Override
        public ILatitude name(String name) {
            eventDto.name = name;
            return this;
        }
    }
}
