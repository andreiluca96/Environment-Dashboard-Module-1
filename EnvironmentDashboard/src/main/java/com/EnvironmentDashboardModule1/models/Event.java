package com.EnvironmentDashboardModule1.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by Luca Andrei on 5/3/2017.
 */
@Entity
@Table(name = "Event")
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Date startingTime;

    private Date endingTime;

    private String severity;

    private String description;

    private String hints;

    private Double radius;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
    }

    public void setEndingTime(Date endingTime) {
        this.endingTime = endingTime;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHints(String hints) {
        this.hints = hints;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getStartingTime() {
        return startingTime;
    }

    public Date getEndingTime() {
        return endingTime;
    }

    public String getSeverity() {
        return severity;
    }

    public String getDescription() {
        return description;
    }

    public String getHints() {
        return hints;
    }

    public Double getRadius() {
        return radius;
    }

}
