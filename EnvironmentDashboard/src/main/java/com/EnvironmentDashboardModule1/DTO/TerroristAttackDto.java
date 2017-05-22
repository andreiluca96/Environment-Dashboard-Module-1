package com.EnvironmentDashboardModule1.DTO;

import com.EnvironmentDashboardModule1.DTO.Interfaces.TerroristAttackInterfaces.*;
import com.EnvironmentDashboardModule1.models.Events.TerroristAttack;

import java.util.Date;

/**
 * Created by Sabina on 5/19/2017.
 */
public class TerroristAttackDto extends CreatingTerroristAttackDto {
    private Long id;

    private TerroristAttackDto() { super(); }

    public static class Builder implements IId, INumberOfTerrorists, IName, IDescription, IEndingDate, IHints, IRadius, ISeverity, IStartingDate, ILatitude, ILongitude {
        private TerroristAttackDto terroristAttackDto = new TerroristAttackDto();

        @Override
        public IRadius hints(String hints) {
            terroristAttackDto.hints = hints;
            return this;
        }

        @Override
        public IHints description(String description) {
            terroristAttackDto.description = description;
            return this;
        }

        @Override
        public ISeverity endingDate(Date endingDate) {
            terroristAttackDto.endingDate = endingDate;
            return this;
        }

        @Override
        public IEndingDate startingDate(Date startingDate) {
            terroristAttackDto.startingDate = startingDate;
            return this;
        }

        @Override
        public INumberOfTerrorists radius(Double radius) {
            terroristAttackDto.radius = radius;
            return this;
        }

        @Override
        public IDescription severity(String severity) {
            terroristAttackDto.severity = severity;
            return this;
        }

        @Override
        public IStartingDate longitude(Double longitude) {
            terroristAttackDto.longitude = longitude;
            return this;
        }

        @Override
        public ILongitude latitude(Double latitude) {
            terroristAttackDto.latitude = latitude;
            return this;
        }

        @Override
        public ILatitude name(String name) {
            terroristAttackDto.name = name;
            return this;
        }

        @Override
        public TerroristAttackDto numberOfTerrorists(Integer numberOfTerrorists) {
            terroristAttackDto.numberOfTerrorists = numberOfTerrorists;
            return terroristAttackDto;
        }

        @Override
        public IName id(Long id) {
            terroristAttackDto.id = id;
            return this;
        }
    }
}
