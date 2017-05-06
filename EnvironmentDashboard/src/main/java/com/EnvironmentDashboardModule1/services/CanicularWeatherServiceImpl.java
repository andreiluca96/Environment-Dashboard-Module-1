package com.EnvironmentDashboardModule1.services;

import com.EnvironmentDashboardModule1.models.MeteoEvents.CanicularWeather;
import com.EnvironmentDashboardModule1.repositories.CanicularWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        return null;

        // Dragos -> copy paste done bad???
        /*
        CanicularWeather canicularweather = this.canicularweatherRepository.findOne(id);
        this.canicularweatherRepository.findOne(id).setDescription(entity.getDescription());
        this.canicularweatherRepository.findOne(id).setStartingTime(entity.getStartingTime());
        this.canicularweatherRepository.findOne(id).setRadius(entity.getRadius());
        this.canicularweatherRepository.findOne(id).setName(entity.getName());
        this.canicularweatherRepository.findOne(id).setHints(entity.getHints());
        this.canicularweatherRepository.findOne(id).setEndingTime(entity.getEndingTime());
        this.canicularweatherRepository.findOne(id).setLatitude(entity.getLatitude());
        this.canicularweatherRepository.findOne(id).setLongitude(entity.getLongitude());
        this.canicularweatherRepository.findOne(id).setSeverity(entity.getSeverity());
        this.canicularweatherRepository.findOne(id).setDepth(entity.getDepth());
        this.canicularweatherRepository.findOne(id).setMercalliDegree(entity.getMercalliDegree());
        this.canicularweatherRepository.findOne(id).setRichterDegree(entity.getRichterDegree());
        this.canicularweatherRepository.saveAndFlush(this.canicularweatherRepository.findOne(id));
        return this.canicularweatherRepository.findOne(id);
        */
    }
}