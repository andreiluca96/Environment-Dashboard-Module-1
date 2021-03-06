/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EnvironmentDashboardModule1.DTO;

import com.EnvironmentDashboardModule1.DTO.Interfaces.SnowInterfaces.*;
import com.EnvironmentDashboardModule1.models.Severity;

import java.util.Date;

/**
 *
 * @author Vladut
 */
public class SnowDto extends CreatingSnowDto {
  private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private SnowDto() {
    super();
    };

    public static class Builder implements IUserId, IId, IName, IDescription, IEndingDate, IHints, IRadius, ISeverity, IStartingDate, ILatitude, ILongitude, IPrecipitationLevel {
        private SnowDto snowDto = new SnowDto();
        

        @Override
        public IRadius hints(String hints) {
            snowDto.hints=hints;
            return this;
        }

        @Override
        public ILatitude name(String name) {
            snowDto.name=name;
            return this;
        }

        @Override
        public IHints description(String description) {
            snowDto.description=description;
            return this;
        }

        @Override
        public ILongitude latitude(Double latitude) {
            snowDto.latitude=latitude;
            return this;
        }

        @Override
        public IDescription severity(Severity severity) {
            snowDto.severity=severity;
            return this;
        }

        @Override
        public IStartingDate longitude(Double longitude) {
            snowDto.longitude=longitude;
            return this;
        }

        @Override
        public ISeverity endingDate(Date endingDate) {
            snowDto.endingDate=endingDate;
            return this;
        }

        @Override
        public IEndingDate startingDate(Date startingDate) {
            snowDto.startingDate=startingDate;
            return this;
        }

        @Override
        public IPrecipitationLevel radius(Double radius) {
            snowDto.radius=radius;
            return this;
        }

        @Override
        public SnowDto precipitationLevel(Integer precipitationLevel) {
            snowDto.precipitationLevel=precipitationLevel;
            return snowDto;
        }

        @Override
        public IName id(Long id) {
            snowDto.id = id;
            return this;
        }

        @Override
        public IId userId(String userId) {
            snowDto.userId = userId;
            return this;
        }
    }
}
