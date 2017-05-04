package com.EnvironmentDashboardModule1.services;

import com.EnvironmentDashboardModule1.models.Events.Tornado;
import com.EnvironmentDashboardModule1.repositories.TornadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Luca Andrei on 5/4/2017.
 */
@Service
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

    public Tornado update(Tornado entity, Long id) {
        Event grade = this.tornadoRepository.findOne(id);
        this.tornadoRepository.findOne(id).setDescription(entity.getDescription());
        this.tornadoRepository.findOne(id).setStartingTime(entity.getStartingTime());
        this.tornadoRepository.findOne(id).setRadius(entity.getRadius());
        this.tornadoRepository.findOne(id).setName(entity.getName());
        this.tornadoRepository.findOne(id).setHints(entity.getHints());
        this.tornadoRepository.findOne(id).setEndingTime(entity.getEndingTime());
        this.tornadoRepository.findOne(id).setLatitude(entity.getLatitude());
        this.tornadoRepository.findOne(id).setLongitude(entity.getLongitude());
        this.tornadoRepository.findOne(id).setSeverity(entity.getSeverity());
        this.tornadoRepository.findOne(id).setWindSpeed(entity.getWindSpeed());
        this.tornadoRepository.saveAndFlush(this.tornadoRepository.findOne(id));
        return this.tornadoRepository.findOne(id);
    }
}
