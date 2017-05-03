package com.EnvironmentDashboardModule1.DTO;

import com.EnvironmentDashboardModule1.DTO.Interfaces.*;
import com.EnvironmentDashboardModule1.models.Location;
import com.EnvironmentDashboardModule1.models.Severity;

import java.util.Date;

/**
 * Created by Luca Andrei on 5/3/2017.
 */
public class EventDto extends CreatingEventDto {
    private Long id;

    private EventDto() {};

    public static class Builder implements IDescription, IEndingDate, IHints, ILocation, IRadius, ISeverity, IStartingDate {
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
        public IDescription severity(Severity severity) {
            eventDto.severity = severity;
            return this;
        }

        @Override
        public IStartingDate location(Location location) {
            eventDto.location = location;
            return this;
        }
    }
}
