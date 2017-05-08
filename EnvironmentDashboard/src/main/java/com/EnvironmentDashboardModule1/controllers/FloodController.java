package com.EnvironmentDashboardModule1.controllers;

/**
 * Created by Sabina on 5/8/2017.
 */

import com.EnvironmentDashboardModule1.DTO.*;
import com.EnvironmentDashboardModule1.models.Builders.EarthquakeBuilder;
import com.EnvironmentDashboardModule1.models.Builders.FloodBuilder;
import com.EnvironmentDashboardModule1.models.Builders.TornadoBuilder;
import com.EnvironmentDashboardModule1.models.Events.Earthquake;
import com.EnvironmentDashboardModule1.models.Events.Event;
import com.EnvironmentDashboardModule1.models.Builders.EventBuilder;
import com.EnvironmentDashboardModule1.models.Events.Flood;
import com.EnvironmentDashboardModule1.models.Events.Tornado;
import com.EnvironmentDashboardModule1.services.EarthquakeService;
import com.EnvironmentDashboardModule1.services.EventService;
import com.EnvironmentDashboardModule1.services.FloodService;
import com.EnvironmentDashboardModule1.services.TornadoService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/events")
public class FloodController {

    @Autowired
    private EventService eventService;

    @Autowired
    private FloodService floodService;

    @RequestMapping(value = "/flood", method = RequestMethod.POST)
    public ResponseEntity<Flood> addFlood(@RequestBody CreatingFloodDto event) {
        Flood flood = toCreatingModel(event);
        Flood savedEvent = this.floodService.save(flood);

        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/flood", method = RequestMethod.GET)
    public ResponseEntity<List<FloodDto>> getFlood() {
        List<Flood> events = this.floodService.getAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Lists.transform(events, event -> toDto(event)), HttpStatus.OK);
    }

    @RequestMapping(value = "/flood/{id}", method = RequestMethod.GET)
    public ResponseEntity<FloodDto> getFloodById(@PathVariable("id") Long id) {
        Flood flood = this.floodService.getById(id);
        if (flood == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(toDto(flood), HttpStatus.OK);
    }

    @RequestMapping(value = "/flood/{id}", method = RequestMethod.PUT)
    public ResponseEntity<FloodDto> updateFlood(@PathVariable("id") Long id,@RequestBody CreatingFloodDto floodDto){
        Flood flood = toCreatingModel(floodDto);
        Flood floodCheck = this.floodService.getById(id);
        if (floodCheck == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Flood updatedFlood= this.floodService.update(flood,id);
        return new ResponseEntity<>(toDto(updatedFlood), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/flood", method = RequestMethod.DELETE)
    public ResponseEntity<List<FloodDto>> deleteFloods() {
        List<Flood> floodList = this.floodService.getAll();

        for (Flood flood : floodList) {
            this.eventService.delete(flood.getId());
        }

        return new ResponseEntity<>(Lists.transform(floodList, event -> toDto(event)), HttpStatus.OK);
    }

    @RequestMapping(value = "flood/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<FloodDto> deleteFloodById(@PathVariable("id") Long id) {
        Flood flood = this.floodService.getById(id);
        if (flood == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.eventService.delete(flood.getId());
        return new ResponseEntity<>(toDto(flood), HttpStatus.OK);
    }


    private FloodDto toDto(Flood flood) {
        return new FloodDto.Builder()
                .name(flood.getName())
                .latitude(flood.getLatitude())
                .longitude(flood.getLongitude())
                .startingDate(flood.getStartingTime())
                .endingDate(flood.getEndingTime())
                .severity(flood.getSeverity())
                .description(flood.getDescription())
                .hints(flood.getHints())
                .radius(flood.getRadius())
                .precipitationLevel(flood.getPrecipitationLevel());
    }

    private Flood toCreatingModel(CreatingFloodDto dto) {
        return new FloodBuilder()
                .setName(dto.getName())
                .setLongitude(dto.getLongitude())
                .setLatitude(dto.getLongitude())
                .setDescription(dto.getDescription())
                .setEndingTime(dto.getEndingDate())
                .setStartingTime(dto.getStartingDate())
                .setHints(dto.getHints())
                .setRadius(dto.getRadius())
                .setSeverity(dto.getSeverity())
                .setPrecipitationLevel(dto.getPrecipitationLevel())
                .getFlood();
    }
}


