package com.EnvironmentDashboardModule1.services.Event;

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
        Tornado tornado = this.tornadoRepository.findOne(id);
        tornado.setDescription(entity.getDescription());
        tornado.setStartingTime(entity.getStartingTime());
        tornado.setRadius(entity.getRadius());
        tornado.setName(entity.getName());
        tornado.setHints(entity.getHints());
        tornado.setEndingTime(entity.getEndingTime());
        tornado.setLatitude(entity.getLatitude());
        tornado.setLongitude(entity.getLongitude());
        tornado.setSeverity(entity.getSeverity());
        tornado.setWindSpeed(entity.getWindSpeed());
        this.tornadoRepository.saveAndFlush(tornado);
        return tornado;
    }
}
