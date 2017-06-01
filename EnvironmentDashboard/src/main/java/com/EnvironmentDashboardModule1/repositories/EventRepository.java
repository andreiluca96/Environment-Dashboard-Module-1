package com.EnvironmentDashboardModule1.repositories;

import com.EnvironmentDashboardModule1.models.Events.Event;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Luca Andrei on 5/4/2017.
 */

/**
 *  Repository API for the Event entity. This interface acts primarily as a marker interface to capture the
 *  types to work with and help to discover interfaces that extend this one.
 *  For each entity, there is a interface with a repository API: Terrorist Attack, Tornado, Tsunami etc.
 */
public interface EventRepository extends JpaRepository<Event, Long> {
}
