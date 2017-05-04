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
        this.coldweatherRepository.findOne(id).setDescription(entity.getDescription());
        this.coldweatherRepository.findOne(id).setStartingTime(entity.getStartingTime());
        this.coldweatherRepository.findOne(id).setRadius(entity.getRadius());
        this.coldweatherRepository.findOne(id).setName(entity.getName());
        this.coldweatherRepository.findOne(id).setHints(entity.getHints());
        this.coldweatherRepository.findOne(id).setEndingTime(entity.getEndingTime());
        this.coldweatherRepository.findOne(id).setLatitude(entity.getLatitude());
        this.coldweatherRepository.findOne(id).setLongitude(entity.getLongitude());
        this.coldweatherRepository.findOne(id).setSeverity(entity.getSeverity());
        this.coldweatherRepository.findOne(id).setDepth(entity.getDepth());
        this.coldweatherRepository.findOne(id).setMercalliDegree(entity.getMercalliDegree());
        this.coldweatherRepository.findOne(id).setRichterDegree(entity.getRichterDegree());
        this.coldweatherRepository.saveAndFlush(this.coldweatherRepository.findOne(id));
        return this.coldweatherRepository.findOne(id);
    }
}