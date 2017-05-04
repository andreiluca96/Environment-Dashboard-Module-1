package com.EnvironmentDashboardModule1.services;

import com.EnvironmentDashboardModule1.models.Events.Tsunami;
import com.EnvironmentDashboardModule1.repositories.TsunamiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TsunamiServiceImpl implements TsunamiService {
    @Autowired
    private TsunamiRepository tsunamiRepository;

    @Override
    public Tsunami save(Tsunami entity) {
        return this.tsunamiRepository.save(entity);
    }

    @Override
    public List<Tsunami> getAll() {
        return this.tsunamiRepository.findAll();
    }

    @Override
    public Tsunami getById(Long id) {
        return this.tsunamiRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        this.tsunamiRepository.delete(id);
    }

    @Override
    public Tsunami update(Tsunami entity, Long id) {
        return null;
    }
}