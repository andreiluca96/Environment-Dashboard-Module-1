package com.EnvironmentDashboardModule1.services.Event;

import com.EnvironmentDashboardModule1.models.Events.Event;
import com.EnvironmentDashboardModule1.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Luca Andrei on 5/4/2017.
 */

/**
 * Event CRUD methods implementation.
 */
@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event save(Event entity) {
        return this.eventRepository.save(entity);
    }

    @Override
    public List<Event> getAll() {
        return this.eventRepository.findAll();
    }

    @Override
    public Event getById(Long id) {
        return this.eventRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        this.eventRepository.delete(id);
    }

    public Event update(Event entity, Long id) {
        Event event = this.eventRepository.findOne(id);
        event.setDescription(entity.getDescription());
        event.setStartingTime(entity.getStartingTime());
        event.setRadius(entity.getRadius());
        event.setName(entity.getName());
        event.setHints(entity.getHints());
        event.setEndingTime(entity.getEndingTime());
        event.setLatitude(entity.getLatitude());
        event.setLongitude(entity.getLongitude());
        event.setSeverity(entity.getSeverity());
        this.eventRepository.saveAndFlush(event);
        return event;
    }
}
