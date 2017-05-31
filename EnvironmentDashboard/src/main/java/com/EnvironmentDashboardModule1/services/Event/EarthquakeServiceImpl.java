package com.EnvironmentDashboardModule1.services.Event;

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
        earthquake.setDescription(entity.getDescription());
        earthquake.setStartingTime(entity.getStartingTime());
        earthquake.setRadius(entity.getRadius());
        earthquake.setName(entity.getName());
        earthquake.setHints(entity.getHints());
        earthquake.setEndingTime(entity.getEndingTime());
        earthquake.setLatitude(entity.getLatitude());
        earthquake.setLongitude(entity.getLongitude());
        earthquake.setSeverity(entity.getSeverity());
        earthquake.setDepth(entity.getDepth());
        earthquake.setMercalliDegree(entity.getMercalliDegree());
        earthquake.setRichterDegree(entity.getRichterDegree());
        this.earthquakeRepository.saveAndFlush(earthquake);
        return earthquake;
    }
}