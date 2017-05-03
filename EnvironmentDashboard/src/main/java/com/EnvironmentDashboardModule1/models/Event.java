package com.EnvironmentDashboardModule1.models;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Luca Andrei on 5/3/2017.
 */
@Entity
@Table(name = "Event")
public class Event {
    String name;
}
