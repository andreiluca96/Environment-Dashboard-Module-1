package com.EnvironmentDashboardModule1.services;

import com.EnvironmentDashboardModule1.models.Event;
import com.EnvironmentDashboardModule1.models.Tornado;
import com.EnvironmentDashboardModule1.repositories.EventRepository;
import com.EnvironmentDashboardModule1.repositories.TornadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Luca Andrei on 5/4/2017.
 */
public class TornadoServiceImpl implements TornadoService {
    @Autowired
    private TornadoRepository tornadoRepository;

    @Override
    public Tornado save(Tornado entity) {
        return this.tornadoRepository.save(entity);
    }

    @Override
    public List<Tornado> getAll() {
        return this.tornadoRepository.findAll();
    }

    @Override
    public Tornado getById(Long id) {
        return this.tornadoRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        this.tornadoRepository.delete(id);
    }
}
