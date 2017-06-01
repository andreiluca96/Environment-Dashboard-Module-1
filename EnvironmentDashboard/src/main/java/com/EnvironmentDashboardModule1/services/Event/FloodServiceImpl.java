package com.EnvironmentDashboardModule1.services.Event;

import com.EnvironmentDashboardModule1.models.Events.Flood;
import com.EnvironmentDashboardModule1.repositories.FloodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Flood CRUD methods implementation.
 */
@Service
public class FloodServiceImpl implements FloodService {
    @Autowired
    private FloodRepository floodRepository;

    @Override
    public Flood save(Flood entity) {
        return this.floodRepository.save(entity);
    }

    @Override
    public List<Flood> getAll() {
        return this.floodRepository.findAll();
    }

    @Override
    public Flood getById(Long id) {
        return this.floodRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        this.floodRepository.delete(id);
    }

    @Override
    public Flood update(Flood entity, Long id) {
        Flood flood = this.floodRepository.findOne(id);
        flood.setDescription(entity.getDescription());
        flood.setStartingTime(entity.getStartingTime());
        flood.setRadius(entity.getRadius());
        flood.setName(entity.getName());
        flood.setHints(entity.getHints());
        flood.setEndingTime(entity.getEndingTime());
        flood.setLatitude(entity.getLatitude());
        flood.setLongitude(entity.getLongitude());
        flood.setSeverity(entity.getSeverity());
        flood.setPrecipitationLevel(entity.getPrecipitationLevel());
        this.floodRepository.saveAndFlush(flood);
        return flood;
    }
}