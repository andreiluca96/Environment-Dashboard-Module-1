package com.EnvironmentDashboardModule1.services;

import com.EnvironmentDashboardModule1.models.MeteoEvents.MeteoEvent;
import com.EnvironmentDashboardModule1.repositories.MeteoEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeteoEventServiceImpl implements MeteoEventService {
    @Autowired
    private MeteoEventRepository meteoeventRepository;

    @Override
    public MeteoEvent save(MeteoEvent entity) {
        return this.meteoeventRepository.save(entity);
    }

    @Override
    public List<MeteoEvent> getAll() {
        return this.meteoeventRepository.findAll();
    }

    @Override
    public MeteoEvent getById(Long id) {
        return this.meteoeventRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        this.meteoeventRepository.delete(id);
    }

    public MeteoEvent update(MeteoEvent entity, Long id) {
        MeteoEvent grade = this.meteoeventRepository.findOne(id);
        this.meteoeventRepository.findOne(id).setDescription(entity.getDescription());
        this.meteoeventRepository.findOne(id).setStartingTime(entity.getStartingTime());
        this.meteoeventRepository.findOne(id).setRadius(entity.getRadius());
        this.meteoeventRepository.findOne(id).setName(entity.getName());
        this.meteoeventRepository.findOne(id).setHints(entity.getHints());
        this.meteoeventRepository.findOne(id).setEndingTime(entity.getEndingTime());
        this.meteoeventRepository.findOne(id).setLatitude(entity.getLatitude());
        this.meteoeventRepository.findOne(id).setLongitude(entity.getLongitude());
        this.meteoeventRepository.findOne(id).setSeverity(entity.getSeverity());
        this.meteoeventRepository.saveAndFlush(this.meteoeventRepository.findOne(id));
        return this.meteoeventRepository.findOne(id);
    }
}