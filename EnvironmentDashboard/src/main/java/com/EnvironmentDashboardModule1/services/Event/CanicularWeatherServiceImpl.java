package com.EnvironmentDashboardModule1.services.Event;

import com.EnvironmentDashboardModule1.models.MeteoEvents.CanicularWeather;
import com.EnvironmentDashboardModule1.repositories.CanicularWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Canicular Weather CRUD methods implementation.
 */
@Service
public class CanicularWeatherServiceImpl implements CanicularWeatherService {
    @Autowired
    private CanicularWeatherRepository canicularweatherRepository;

    @Override
    public CanicularWeather save(CanicularWeather entity) {
        return this.canicularweatherRepository.save(entity);
    }

    @Override
    public List<CanicularWeather> getAll() {
        return this.canicularweatherRepository.findAll();
    }

    @Override
    public CanicularWeather getById(Long id) {
        return this.canicularweatherRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        this.canicularweatherRepository.delete(id);
    }

    public CanicularWeather update(CanicularWeather entity, Long id) {
        CanicularWeather canicularweather = this.canicularweatherRepository.findOne(id);
        canicularweather.setDescription(entity.getDescription());
        canicularweather.setStartingTime(entity.getStartingTime());
        canicularweather.setRadius(entity.getRadius());
        canicularweather.setName(entity.getName());
        canicularweather.setHints(entity.getHints());
        canicularweather.setEndingTime(entity.getEndingTime());
        canicularweather.setLatitude(entity.getLatitude());
        canicularweather.setLongitude(entity.getLongitude());
        canicularweather.setSeverity(entity.getSeverity());
        canicularweather.setHumidity(entity.getHumidity());
        canicularweather.setPrecipitationLevel(entity.getPrecipitationLevel());
        canicularweather.setTemperature(entity.getTemperature());
        this.canicularweatherRepository.saveAndFlush(canicularweather);
        return canicularweather ;
    }
}