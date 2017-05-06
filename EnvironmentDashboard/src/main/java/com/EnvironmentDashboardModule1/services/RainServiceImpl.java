package com.EnvironmentDashboardModule1.services;

import com.EnvironmentDashboardModule1.models.MeteoEvents.Rain;
import com.EnvironmentDashboardModule1.repositories.RainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RainServiceImpl implements RainService {
    @Autowired
    private RainRepository rainRepository;

    @Override
    public Rain save(Rain entity) {
        return this.rainRepository.save(entity);
    }

    @Override
    public List<Rain> getAll() {
        return this.rainRepository.findAll();
    }

    @Override
    public Rain getById(Long id) {
        return this.rainRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        this.rainRepository.delete(id);
    }

    public Rain update(Rain entity, Long id) {

        return null;

        // Dragos -> copy paste done bad???
        /*
        Rain rain = this.rainRepository.findOne(id);
        this.rainRepository.findOne(id).setDescription(entity.getDescription());
        this.rainRepository.findOne(id).setStartingTime(entity.getStartingTime());
        this.rainRepository.findOne(id).setRadius(entity.getRadius());
        this.rainRepository.findOne(id).setName(entity.getName());
        this.rainRepository.findOne(id).setHints(entity.getHints());
        this.rainRepository.findOne(id).setEndingTime(entity.getEndingTime());
        this.rainRepository.findOne(id).setLatitude(entity.getLatitude());
        this.rainRepository.findOne(id).setLongitude(entity.getLongitude());
        this.rainRepository.findOne(id).setSeverity(entity.getSeverity());
        this.rainRepository.findOne(id).setDepth(entity.getDepth());
        this.rainRepository.findOne(id).setMercalliDegree(entity.getMercalliDegree());
        this.rainRepository.findOne(id).setRichterDegree(entity.getRichterDegree());
        this.rainRepository.saveAndFlush(this.rainRepository.findOne(id));
        return this.rainRepository.findOne(id);
        */
    }
}