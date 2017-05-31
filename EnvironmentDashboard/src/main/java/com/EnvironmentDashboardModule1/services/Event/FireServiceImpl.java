package com.EnvironmentDashboardModule1.services.Event;

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
        fire.setDescription(entity.getDescription());
        fire.setStartingTime(entity.getStartingTime());
        fire.setRadius(entity.getRadius());
        fire.setName(entity.getName());
        fire.setHints(entity.getHints());
        fire.setEndingTime(entity.getEndingTime());
        fire.setLatitude(entity.getLatitude());
        fire.setLongitude(entity.getLongitude());
        fire.setSeverity(entity.getSeverity());
        fire.setSpeed(entity.getSpeed());
        this.fireRepository.saveAndFlush(fire);
        return fire;
    }
}