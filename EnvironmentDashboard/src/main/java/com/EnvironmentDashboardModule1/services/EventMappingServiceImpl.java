package com.EnvironmentDashboardModule1.services;

import com.EnvironmentDashboardModule1.models.EventMapping;
import com.EnvironmentDashboardModule1.repositories.EventMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Luca Andrei on 5/18/2017.
 */
@Service
public class EventMappingServiceImpl implements  EventMappingService {
    @Autowired
    private EventMappingRepository eventMappingRepository;

    @Override
    public EventMapping save(EventMapping entity) {
        return this.eventMappingRepository.save(entity);
    }

    @Override
    public List<EventMapping> getAll() {
        return this.eventMappingRepository.findAll();
    }

    @Override
    public EventMapping getById(Long id) {
        return this.eventMappingRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        this.eventMappingRepository.delete(id);
    }

    public EventMapping update(EventMapping entity, Long id) {
        EventMapping eventMapping = this.eventMappingRepository.findOne(id);
        eventMapping.setEventType(entity.getEventType());

        this.eventMappingRepository.saveAndFlush(eventMapping);
        return eventMapping;
    }

}
