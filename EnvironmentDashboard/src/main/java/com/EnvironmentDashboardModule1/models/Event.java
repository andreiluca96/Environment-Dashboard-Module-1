package com.EnvironmentDashboardModule1.models;

import org.springframework.beans.factory.annotation.Autowired;

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
    private Integer id;

    private String name;

    private Date startingTime;

    private Date endingTime;

    private String severity;

    private String description;

    private String hints;

    private Double latitude;

    private Double longitude;

    private Double radius;

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setId(Integer id) {
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHints(String hints) {
        this.hints = hints;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }


    public Integer getId() {
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
