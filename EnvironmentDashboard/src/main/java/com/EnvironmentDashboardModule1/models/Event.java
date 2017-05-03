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
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date startingTime;

    @Column(nullable = false)
    private Date endingTime;

    @Column(nullable = false)
    private Severity sevirity;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String hints;

    @Column(nullable = false)
    private Double radius;

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

    public void setSevirity(Severity sevirity) {
        this.sevirity = sevirity;
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

    public Severity getSevirity() {
        return sevirity;
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
