package com.EnvironmentDashboardModule1.services;

import com.EnvironmentDashboardModule1.models.MeteoEvents.Snow;
import com.EnvironmentDashboardModule1.repositories.SnowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SnowServiceImpl implements SnowService {
    @Autowired
    private SnowRepository snowRepository;

    @Override
    public Snow save(Snow entity) {
        return this.snowRepository.save(entity);
    }

    @Override
    public List<Snow> getAll() {
        return this.snowRepository.findAll();
    }

    @Override
    public Snow getById(Long id) {
        return this.snowRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        this.snowRepository.delete(id);
    }

    public Snow update(Snow entity, Long id) {
        Snow snow = this.snowRepository.findOne(id);
        this.snowRepository.findOne(id).setDescription(entity.getDescription());
        this.snowRepository.findOne(id).setStartingTime(entity.getStartingTime());
        this.snowRepository.findOne(id).setRadius(entity.getRadius());
        this.snowRepository.findOne(id).setName(entity.getName());
        this.snowRepository.findOne(id).setHints(entity.getHints());
        this.snowRepository.findOne(id).setEndingTime(entity.getEndingTime());
        this.snowRepository.findOne(id).setLatitude(entity.getLatitude());
        this.snowRepository.findOne(id).setLongitude(entity.getLongitude());
        this.snowRepository.findOne(id).setSeverity(entity.getSeverity());
        this.snowRepository.findOne(id).setDepth(entity.getDepth());
        this.snowRepository.findOne(id).setMercalliDegree(entity.getMercalliDegree());
        this.snowRepository.findOne(id).setRichterDegree(entity.getRichterDegree());
        this.snowRepository.saveAndFlush(this.snowRepository.findOne(id));
        return this.snowRepository.findOne(id);
    }
}