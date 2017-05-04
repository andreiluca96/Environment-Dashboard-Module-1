package com.EnvironmentDashboardModule1.services;

import com.EnvironmentDashboardModule1.models.Event;
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
}
