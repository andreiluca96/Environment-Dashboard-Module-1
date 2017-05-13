package com.EnvironmentDashboardModule1.services;

import com.EnvironmentDashboardModule1.models.MeteoEvents.Fog;
import com.EnvironmentDashboardModule1.repositories.FogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FogServiceImpl implements FogService {
    @Autowired
    private FogRepository fogRepository;

    @Override
    public Fog save(Fog entity) {
        return this.fogRepository.save(entity);
    }

    @Override
    public List<Fog> getAll() {
        return this.fogRepository.findAll();
    }

    @Override
    public Fog getById(Long id) {
        return this.fogRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        this.fogRepository.delete(id);
    }

    public Fog update(Fog entity, Long id) {
        Fog fog = this.fogRepository.findOne(id);
        fog.setDescription(entity.getDescription());
        fog.setStartingTime(entity.getStartingTime());
        fog.setRadius(entity.getRadius());
        fog.setName(entity.getName());
        fog.setHints(entity.getHints());
        fog.setEndingTime(entity.getEndingTime());
        fog.setLatitude(entity.getLatitude());
        fog.setLongitude(entity.getLongitude());
        fog.setSeverity(entity.getSeverity());
        fog.setHumidity(entity.getHumidity());
        fog.setPrecipitationLevel(entity.getPrecipitationLevel());
        fog.setTemperature(entity.getTemperature());
        this.fogRepository.saveAndFlush(fog);
        return fog ;
    }
}