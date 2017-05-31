package com.EnvironmentDashboardModule1.services.Event;

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
        MeteoEvent meteoEvent = this.meteoeventRepository.findOne(id);
        meteoEvent.setDescription(entity.getDescription());
        meteoEvent.setStartingTime(entity.getStartingTime());
        meteoEvent.setRadius(entity.getRadius());
        meteoEvent.setName(entity.getName());
        meteoEvent.setHints(entity.getHints());
        meteoEvent.setEndingTime(entity.getEndingTime());
        meteoEvent.setLatitude(entity.getLatitude());
        meteoEvent.setLongitude(entity.getLongitude());
        meteoEvent.setSeverity(entity.getSeverity());
        meteoEvent.setHumidity(entity.getHumidity());
        meteoEvent.setPrecipitationLevel(entity.getPrecipitationLevel());
        meteoEvent.setTemperature(entity.getTemperature());
        this.meteoeventRepository.saveAndFlush(meteoEvent);
        return meteoEvent ;

    }
}