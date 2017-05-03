package com.EnvironmentDashboardModule1.DTO;

import com.EnvironmentDashboardModule1.models.Location;
import com.EnvironmentDashboardModule1.models.Severity;

import java.util.Date;

/**
 * Created by Luca Andrei on 5/3/2017.
 */
public class CreatingEventDto {
    protected Location location;
    protected Date startingDate;
    protected Date endingDate;
    protected Severity severity;
    protected String description;
    protected String hints;
    protected Double radius;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHints() {
        return hints;
    }

    public void setHints(String hints) {
        this.hints = hints;
    }

    public double getRadius() {
        return radius;
    }

}
