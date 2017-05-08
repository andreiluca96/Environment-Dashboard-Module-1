package com.EnvironmentDashboardModule1.services;

import com.EnvironmentDashboardModule1.models.Events.Flood;
import com.EnvironmentDashboardModule1.repositories.FloodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        this.floodRepository.findOne(id).setDescription(entity.getDescription());
        this.floodRepository.findOne(id).setStartingTime(entity.getStartingTime());
        this.floodRepository.findOne(id).setRadius(entity.getRadius());
        this.floodRepository.findOne(id).setName(entity.getName());
        this.floodRepository.findOne(id).setHints(entity.getHints());
        this.floodRepository.findOne(id).setEndingTime(entity.getEndingTime());
        this.floodRepository.findOne(id).setLatitude(entity.getLatitude());
        this.floodRepository.findOne(id).setLongitude(entity.getLongitude());
        this.floodRepository.findOne(id).setSeverity(entity.getSeverity());
        this.floodRepository.findOne(id).setPrecipitationLevel(entity.getPrecipitationLevel());
        this.floodRepository.saveAndFlush(this.floodRepository.findOne(id));
        return this.floodRepository.findOne(id);
    }
}