package com.EnvironmentDashboardModule1.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Luca Andrei on 5/18/2017.
 */
@Entity
@Table(name = "Event")
public class EventMapping {
    @Id
    private Long id;

    private String eventType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
