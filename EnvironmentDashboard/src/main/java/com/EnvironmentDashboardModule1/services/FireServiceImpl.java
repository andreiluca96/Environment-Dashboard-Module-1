package com.EnvironmentDashboardModule1.services;

import com.EnvironmentDashboardModule1.models.Events.Fire;
import com.EnvironmentDashboardModule1.repositories.FireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FireServiceImpl implements FireService {
    @Autowired
    private FireRepository fireRepository;

    @Override
    public Fire save(Fire entity) {
        return this.fireRepository.save(entity);
    }

    @Override
    public List<Fire> getAll() {
        return this.fireRepository.findAll();
    }

    @Override
    public Fire getById(Long id) {
        return this.fireRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        this.fireRepository.delete(id);
    }

    @Override
    public Fire update(Fire entity, Long id) {
        return null;
    }
}