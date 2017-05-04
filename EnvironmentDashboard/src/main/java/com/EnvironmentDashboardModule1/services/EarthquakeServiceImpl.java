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
}