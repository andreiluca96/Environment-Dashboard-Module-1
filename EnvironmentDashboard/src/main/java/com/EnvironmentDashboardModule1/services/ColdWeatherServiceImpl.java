package com.EnvironmentDashboardModule1.services;

import com.EnvironmentDashboardModule1.models.MeteoEvents.ColdWeather;
import com.EnvironmentDashboardModule1.repositories.ColdWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColdWeatherServiceImpl implements ColdWeatherService {
    @Autowired
    private ColdWeatherRepository coldweatherRepository;

    @Override
    public ColdWeather save(ColdWeather entity) {
        return this.coldweatherRepository.save(entity);
    }

    @Override
    public List<ColdWeather> getAll() {
        return this.coldweatherRepository.findAll();
    }

    @Override
    public ColdWeather getById(Long id) {
        return this.coldweatherRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        this.coldweatherRepository.delete(id);
    }

    public ColdWeather update(ColdWeather entity, Long id) {
        ColdWeather coldweather = this.coldweatherRepository.findOne(id);
        coldweather.setDescription(entity.getDescription());
        coldweather.setStartingTime(entity.getStartingTime());
        coldweather.setRadius(entity.getRadius());
        coldweather.setName(entity.getName());
        coldweather.setHints(entity.getHints());
        coldweather.setEndingTime(entity.getEndingTime());
        coldweather.setLatitude(entity.getLatitude());
        coldweather.setLongitude(entity.getLongitude());
        coldweather.setSeverity(entity.getSeverity());
        coldweather.setHumidity(entity.getHumidity());
        coldweather.setPrecipitationLevel(entity.getPrecipitationLevel());
        coldweather.setTemperature(entity.getTemperature());
        this.coldweatherRepository.saveAndFlush(coldweather);
        return coldweather ;
    }
}