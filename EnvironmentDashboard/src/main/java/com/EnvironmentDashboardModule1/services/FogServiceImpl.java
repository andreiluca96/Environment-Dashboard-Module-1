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

        return null;

        //Dragos -> copy paste done bad???
        /*
        Fog fog = this.fogRepository.findOne(id);
        this.fogRepository.findOne(id).setDescription(entity.getDescription());
        this.fogRepository.findOne(id).setStartingTime(entity.getStartingTime());
        this.fogRepository.findOne(id).setRadius(entity.getRadius());
        this.fogRepository.findOne(id).setName(entity.getName());
        this.fogRepository.findOne(id).setHints(entity.getHints());
        this.fogRepository.findOne(id).setEndingTime(entity.getEndingTime());
        this.fogRepository.findOne(id).setLatitude(entity.getLatitude());
        this.fogRepository.findOne(id).setLongitude(entity.getLongitude());
        this.fogRepository.findOne(id).setSeverity(entity.getSeverity());
        this.fogRepository.findOne(id).setDepth(entity.getDepth());
        this.fogRepository.findOne(id).setMercalliDegree(entity.getMercalliDegree());
        this.fogRepository.findOne(id).setRichterDegree(entity.getRichterDegree());
        this.fogRepository.saveAndFlush(this.fogRepository.findOne(id));
        return this.fogRepository.findOne(id);
        */
    }
}