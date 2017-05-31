package com.EnvironmentDashboardModule1.services.Event;

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
        Rain rain = this.rainRepository.findOne(id);
        rain.setDescription(entity.getDescription());
        rain.setStartingTime(entity.getStartingTime());
        rain.setRadius(entity.getRadius());
        rain.setName(entity.getName());
        rain.setHints(entity.getHints());
        rain.setEndingTime(entity.getEndingTime());
        rain.setLatitude(entity.getLatitude());
        rain.setLongitude(entity.getLongitude());
        rain.setSeverity(entity.getSeverity());
        rain.setHumidity(entity.getHumidity());
        rain.setPrecipitationLevel(entity.getPrecipitationLevel());
        rain.setTemperature(entity.getTemperature());
        this.rainRepository.saveAndFlush(rain);
        return rain ;

    }
}