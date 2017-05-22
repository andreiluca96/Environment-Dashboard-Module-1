package com.EnvironmentDashboardModule1.controllers;

/**
 * Created by Ariana on 5/12/2017.
 */

import com.EnvironmentDashboardModule1.DTO.CreatingTsunamiDto;
import com.EnvironmentDashboardModule1.DTO.TsunamiDto;
import com.EnvironmentDashboardModule1.models.EventMapping;
import com.EnvironmentDashboardModule1.models.Events.Tsunami;
import com.EnvironmentDashboardModule1.services.EventMappingService;
import com.EnvironmentDashboardModule1.services.EventService;
import com.EnvironmentDashboardModule1.services.TsunamiService;
import com.EnvironmentDashboardModule1.models.Builders.EventBuilders.TsunamiBuilder;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("v1/events")
public class TsunamiController {
    @Autowired
    private EventService eventService;

    @Autowired
    private TsunamiService tsunamiService;

    @Autowired
    private EventMappingService eventMappingService;

    @RequestMapping(value = "/tsunami", method = RequestMethod.POST)
    public ResponseEntity<Tsunami> addTornado(@RequestBody CreatingTsunamiDto event) {
        Tsunami tornado = toCreatingModel(event);
        Tsunami savedEvent = this.tsunamiService.save(tornado);

        EventMapping eventMapping = new EventMapping(savedEvent.getId(), "Tsunami");
        eventMappingService.save(eventMapping);

        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/tsunami", method = RequestMethod.GET)
    public ResponseEntity<List<TsunamiDto>> getTsunamis() {
        List<Tsunami> tsunamis = this.tsunamiService.getAll();
        if (tsunamis.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Lists.transform(tsunamis, event -> toDto(event)), HttpStatus.OK);
    }

    @RequestMapping(value = "/tsunami/{id}", method = RequestMethod.GET)
    public ResponseEntity<TsunamiDto> getTsunamiById(@PathVariable("id") Long id) {
        Tsunami tsunami = this.tsunamiService.getById(id);
        if (tsunami == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(toDto(tsunami), HttpStatus.OK);
    }

    @RequestMapping(value = "/tsunami/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TsunamiDto> updateTsunami(@PathVariable("id") Long id, @RequestBody CreatingTsunamiDto tsunamiDto) {
        Tsunami tsunami = toCreatingModel(tsunamiDto);
        Tsunami tsunamiCheck = this.tsunamiService.getById(id);
        if (tsunamiCheck == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Tsunami updatedTsunami = this.tsunamiService.update(tsunami, id);
        return new ResponseEntity<>(toDto(updatedTsunami), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/tsunami", method = RequestMethod.DELETE)
    public ResponseEntity<List<TsunamiDto>> deleteTsunamis() {
        List<Tsunami> tsunamiList = this.tsunamiService.getAll();

        for (Tsunami tsunami : tsunamiList) {
            this.eventService.delete(tsunami.getId());
        }

        return new ResponseEntity<>(Lists.transform(tsunamiList, event -> toDto(event)), HttpStatus.OK);
    }

    @RequestMapping(value = "tsunami/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TsunamiDto> deleteTsunamiById(@PathVariable("id") Long id) {
        Tsunami tsunami = this.tsunamiService.getById(id);
        if (tsunami == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.eventService.delete(tsunami.getId());
        return new ResponseEntity<>(toDto(tsunami), HttpStatus.OK);
    }

    private TsunamiDto toDto(Tsunami tsunami) {
        return new TsunamiDto.Builder()
                .id(tsunami.getId())
                .name(tsunami.getName())
                .latitude(tsunami.getLatitude())
                .longitude(tsunami.getLongitude())
                .startingDate(tsunami.getStartingTime())
                .endingDate(tsunami.getEndingTime())
                .severity(tsunami.getSeverity())
                .description(tsunami.getDescription())
                .hints(tsunami.getHints())
                .radius(tsunami.getRadius())
                .maxWaveWeight(tsunami.getMaxWaveHeight());
    }

    private Tsunami toCreatingModel(CreatingTsunamiDto dto) {
        return new TsunamiBuilder()
                .setName(dto.getName())
                .setLongitude(dto.getLongitude())
                .setLatitude(dto.getLongitude())
                .setDescription(dto.getDescription())
                .setEndingTime(dto.getEndingDate())
                .setStartingTime(dto.getStartingDate())
                .setHints(dto.getHints())
                .setRadius(dto.getRadius())
                .setSeverity(dto.getSeverity())
                .setMaxWaveHeight(dto.getMaxWaveHeight())
                .getTsunami();
    }
}

