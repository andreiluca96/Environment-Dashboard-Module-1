package com.EnvironmentDashboardModule1.services;

import com.EnvironmentDashboardModule1.models.Events.Event;
import com.EnvironmentDashboardModule1.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Luca Andrei on 5/4/2017.
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
        Event grade = this.eventRepository.findOne(id);
        this.eventRepository.findOne(id).setDescription(entity.getDescription());
        this.eventRepository.findOne(id).setStartingTime(entity.getStartingTime());
        this.eventRepository.findOne(id).setRadius(entity.getRadius());
        this.eventRepository.findOne(id).setName(entity.getName());
        this.eventRepository.findOne(id).setHints(entity.getHints());
        this.eventRepository.findOne(id).setEndingTime(entity.getEndingTime());
        this.eventRepository.findOne(id).setLatitude(entity.getLatitude());
        this.eventRepository.findOne(id).setLongitude(entity.getLongitude());
        this.eventRepository.findOne(id).setSeverity(entity.getSeverity());
        this.eventRepository.saveAndFlush(this.eventRepository.findOne(id));
        return this.eventRepository.findOne(id);
    }
}
