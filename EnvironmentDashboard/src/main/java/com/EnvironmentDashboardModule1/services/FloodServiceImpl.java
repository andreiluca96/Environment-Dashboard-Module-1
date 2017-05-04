package com.EnvironmentDashboardModule1.services;

import com.EnvironmentDashboardModule1.models.Events.Flood;
import com.EnvironmentDashboardModule1.repositories.FloodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloodServiceImpl implements FloodService {
    @Autowired
    private FloodRepository floodRepository;

    @Override
    public Flood save(Flood entity) {
        return this.floodRepository.save(entity);
    }

    @Override
    public List<Flood> getAll() {
        return this.floodRepository.findAll();
    }

    @Override
    public Flood getById(Long id) {
        return this.floodRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        this.floodRepository.delete(id);
    }
}