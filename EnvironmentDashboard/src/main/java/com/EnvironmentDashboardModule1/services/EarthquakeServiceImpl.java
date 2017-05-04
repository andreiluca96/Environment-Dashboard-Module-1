package com.EnvironmentDashboardModule1.services;

import com.EnvironmentDashboardModule1.models.Events.Earthquake;
import com.EnvironmentDashboardModule1.repositories.EarthquakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sfarghiu Andrei on 5/4/2017.
 */
@Service
public class EarthquakeServiceImpl implements EarthquakeService {
    @Autowired
    private EarthquakeRepository earthquakeRepository;

    @Override
    public Earthquake save(Earthquake entity) {
        return this.earthquakeRepository.save(entity);
    }

    @Override
    public List<Earthquake> getAll() {
        return this.earthquakeRepository.findAll();
    }

    @Override
    public Earthquake getById(Long id) {
        return this.earthquakeRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        this.earthquakeRepository.delete(id);
    }

    public Earthquake update(Earthquake entity, Long id) {
        Earthquake earthquake = this.earthquakeRepository.findOne(id);
        this.earthquakeRepository.findOne(id).setDescription(entity.getDescription());
        this.earthquakeRepository.findOne(id).setStartingTime(entity.getStartingTime());
        this.earthquakeRepository.findOne(id).setRadius(entity.getRadius());
        this.earthquakeRepository.findOne(id).setName(entity.getName());
        this.earthquakeRepository.findOne(id).setHints(entity.getHints());
        this.earthquakeRepository.findOne(id).setEndingTime(entity.getEndingTime());
        this.earthquakeRepository.findOne(id).setLatitude(entity.getLatitude());
        this.earthquakeRepository.findOne(id).setLongitude(entity.getLongitude());
        this.earthquakeRepository.findOne(id).setSeverity(entity.getSeverity());
        this.earthquakeRepository.findOne(id).setDepth(entity.getDepth());
        this.earthquakeRepository.findOne(id).setMercalliDegree(entity.getMercalliDegree());
        this.earthquakeRepository.findOne(id).setRichterDegree(entity.getRichterDegree());
        this.earthquakeRepository.saveAndFlush(this.earthquakeRepository.findOne(id));
        return this.earthquakeRepository.findOne(id);
    }
}