package com.EnvironmentDashboardModule1.services.Event;

import com.EnvironmentDashboardModule1.models.Events.TerroristAttack;
import com.EnvironmentDashboardModule1.repositories.TerroristAttackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerroristAttackServiceImpl implements TerroristAttackService {
    @Autowired
    private TerroristAttackRepository terroristattackRepository;

    @Override
    public TerroristAttack save(TerroristAttack entity) {
        return this.terroristattackRepository.save(entity);
    }

    @Override
    public List<TerroristAttack> getAll() {
        return this.terroristattackRepository.findAll();
    }

    @Override
    public TerroristAttack getById(Long id) {
        return this.terroristattackRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        this.terroristattackRepository.delete(id);
    }

    @Override
    public TerroristAttack update(TerroristAttack entity, Long id) {
        TerroristAttack terroristAttack = this.terroristattackRepository.findOne(id);
        terroristAttack.setDescription(entity.getDescription());
        terroristAttack.setStartingTime(entity.getStartingTime());
        terroristAttack.setRadius(entity.getRadius());
        terroristAttack.setName(entity.getName());
        terroristAttack.setHints(entity.getHints());
        terroristAttack.setEndingTime(entity.getEndingTime());
        terroristAttack.setLatitude(entity.getLatitude());
        terroristAttack.setLongitude(entity.getLongitude());
        terroristAttack.setSeverity(entity.getSeverity());
        terroristAttack.setNumberOfTerrorists(entity.getNumberOfTerrorists());
        this.terroristattackRepository.saveAndFlush(terroristAttack);
        return terroristAttack;
    }
}