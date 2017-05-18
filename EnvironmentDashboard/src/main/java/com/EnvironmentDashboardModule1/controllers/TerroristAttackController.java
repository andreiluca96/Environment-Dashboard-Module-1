package com.EnvironmentDashboardModule1.controllers;

import com.EnvironmentDashboardModule1.DTO.CreatingTerroristAttackDto;
import com.EnvironmentDashboardModule1.DTO.TerroristAttackDto;
import com.EnvironmentDashboardModule1.models.Builders.EventBuilders.TerroristAttackBuilder;
import com.EnvironmentDashboardModule1.models.EventMapping;
import com.EnvironmentDashboardModule1.models.Events.TerroristAttack;
import com.EnvironmentDashboardModule1.services.EventMappingService;
import com.EnvironmentDashboardModule1.services.EventService;
import com.EnvironmentDashboardModule1.services.TerroristAttackService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sabina on 5/19/2017.
 */

    @RestController
    @RequestMapping("v1/events")
    public class TerroristAttackController {
        @Autowired
        private EventService eventService;

        @Autowired
        private TerroristAttackService terroristAttackService;

        @Autowired
        private EventMappingService eventMappingService;

        @RequestMapping(value = "/terroristAttack", method = RequestMethod.POST)
        public ResponseEntity<TerroristAttack> addTerroristAttack(@RequestBody CreatingTerroristAttackDto event) {
            TerroristAttack terroristAttack = toCreatingModel(event);
            TerroristAttack savedEvent = this.terroristAttackService.save(terroristAttack);

            EventMapping eventMapping = new EventMapping(savedEvent.getId(), "TerroristAttack");
            eventMappingService.save(eventMapping);

            return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
        }

        @RequestMapping(value = "/terroristAttack", method = RequestMethod.GET)
        public ResponseEntity<List<TerroristAttackDto>> getTerroristAttacks() {
            List<TerroristAttack> events = this.terroristAttackService.getAll();
            if (events.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(Lists.transform(events, event -> toDto(event)), HttpStatus.OK);
        }

        @RequestMapping(value = "/terroristAttack/{id}", method = RequestMethod.GET)
        public ResponseEntity<TerroristAttackDto> getTerroristAttackById(@PathVariable("id") Long id) {
            TerroristAttack terroristAttack = this.terroristAttackService.getById(id);
            if (terroristAttack == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(toDto(terroristAttack), HttpStatus.OK);
        }

        @RequestMapping(value = "/terroristAttack/{id}", method = RequestMethod.PUT)
        public ResponseEntity<TerroristAttackDto> updateTerroristAttack(@PathVariable("id") Long id, @RequestBody CreatingTerroristAttackDto terroristAttackDto) {
            TerroristAttack terroristAttack = toCreatingModel(terroristAttackDto);
            TerroristAttack terroristAttackCheck = this.terroristAttackService.getById(id);
            if (terroristAttackCheck == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            TerroristAttack updatedTerroristAttack = this.terroristAttackService.update(terroristAttack, id);
            return new ResponseEntity<>(toDto(updatedTerroristAttack), HttpStatus.CREATED);
        }

        @RequestMapping(value = "/terroristAttack", method = RequestMethod.DELETE)
        public ResponseEntity<List<TerroristAttackDto>> deleteTerroristAttacks() {
            List<TerroristAttack> terroristAttackList = this.terroristAttackService.getAll();

            for (TerroristAttack terroristAttack : terroristAttackList) {
                this.eventService.delete(terroristAttack.getId());
            }

            return new ResponseEntity<>(Lists.transform(terroristAttackList, event -> toDto(event)), HttpStatus.OK);
        }

        @RequestMapping(value = "terroristAttack/{id}", method = RequestMethod.DELETE)
        public ResponseEntity<TerroristAttackDto> deleteTerroristAttackById(@PathVariable("id") Long id) {
            TerroristAttack terroristAttack = this.terroristAttackService.getById(id);
            if (terroristAttack == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            this.eventService.delete(terroristAttack.getId());
            return new ResponseEntity<>(toDto(terroristAttack), HttpStatus.OK);
        }

        private TerroristAttackDto toDto(TerroristAttack terroristAttack) {
            return new TerroristAttackDto.Builder()
                    .name(terroristAttack.getName())
                    .latitude(terroristAttack.getLatitude())
                    .longitude(terroristAttack.getLongitude())
                    .startingDate(terroristAttack.getStartingTime())
                    .endingDate(terroristAttack.getEndingTime())
                    .severity(terroristAttack.getSeverity())
                    .description(terroristAttack.getDescription())
                    .hints(terroristAttack.getHints())
                    .radius(terroristAttack.getRadius())
                    .numberOfTerrorists(terroristAttack.getNumberOfTerrorists());
        }

        private TerroristAttack toCreatingModel(CreatingTerroristAttackDto dto) {
            return new TerroristAttackBuilder()
                    .setName(dto.getName())
                    .setLongitude(dto.getLongitude())
                    .setLatitude(dto.getLongitude())
                    .setDescription(dto.getDescription())
                    .setEndingTime(dto.getEndingDate())
                    .setStartingTime(dto.getStartingDate())
                    .setHints(dto.getHints())
                    .setRadius(dto.getRadius())
                    .setSeverity(dto.getSeverity())
                    .setNumberOfTerrorists(dto.getNumberOfTerrorists())
                    .getTerroristAttack();
        }
    }


