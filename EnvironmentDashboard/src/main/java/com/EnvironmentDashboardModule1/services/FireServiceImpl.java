package com.EnvironmentDashboardModule1.services;

import com.EnvironmentDashboardModule1.models.Events.Fire;
import com.EnvironmentDashboardModule1.repositories.FireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FireServiceImpl implements FireService {
    @Autowired
    private FireRepository fireRepository;

    @Override
    public Fire save(Fire entity) {
        return this.fireRepository.save(entity);
    }

    @Override
    public List<Fire> getAll() {
        return this.fireRepository.findAll();
    }

    @Override
    public Fire getById(Long id) {
        return this.fireRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        this.fireRepository.delete(id);
    }

    @Override
    public Fire update(Fire entity, Long id) {
        Fire fire = this.fireRepository.findOne(id);
        this.fireRepository.findOne(id).setDescription(entity.getDescription());
        this.fireRepository.findOne(id).setStartingTime(entity.getStartingTime());
        this.fireRepository.findOne(id).setRadius(entity.getRadius());
        this.fireRepository.findOne(id).setName(entity.getName());
        this.fireRepository.findOne(id).setHints(entity.getHints());
        this.fireRepository.findOne(id).setEndingTime(entity.getEndingTime());
        this.fireRepository.findOne(id).setLatitude(entity.getLatitude());
        this.fireRepository.findOne(id).setLongitude(entity.getLongitude());
        this.fireRepository.findOne(id).setSeverity(entity.getSeverity());
        this.fireRepository.findOne(id).setSpeed(entity.getSpeed());
        this.fireRepository.saveAndFlush(this.fireRepository.findOne(id));
        return this.fireRepository.findOne(id);
    }
}