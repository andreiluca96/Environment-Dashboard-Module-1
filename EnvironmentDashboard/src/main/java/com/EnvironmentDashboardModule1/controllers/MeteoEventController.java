package com.EnvironmentDashboardModule1.controllers;

import com.EnvironmentDashboardModule1.DTO.CreatingMeteoEventDto;
import com.EnvironmentDashboardModule1.DTO.MeteoEventDto;
import com.EnvironmentDashboardModule1.models.Builders.MeteoEventBuilders.MeteoEventBuilder;
import com.EnvironmentDashboardModule1.models.MeteoEvents.MeteoEvent;
import com.EnvironmentDashboardModule1.services.MeteoEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.common.collect.Lists;


import java.util.List;

/**
 * Created by Ariana on 5/13/2017.
 */
@RestController
@RequestMapping("v1/meteoevents")
public class MeteoEventController {

    @Autowired
    private MeteoEventService meteoEventService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<MeteoEvent> addEvent(@RequestBody CreatingMeteoEventDto meteoEventDto) {
        MeteoEvent meteoEvent = toCreatingModel(meteoEventDto);
        MeteoEvent savedMeteoEvent = this.meteoEventService.save(meteoEvent);
        return new ResponseEntity<>(savedMeteoEvent, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<MeteoEventDto>> get() {
        List<MeteoEvent> meteoEvents = this.meteoEventService.getAll();
        if (meteoEvents.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Lists.transform(meteoEvents, meteoEvent -> toDto(meteoEvent)), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<MeteoEventDto> getById(@PathVariable("id") Long id) {
        MeteoEvent event = this.meteoEventService.getById(id);
        if (event == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(toDto(event), HttpStatus.OK);
    }

    @RequestMapping(value = "/meteoevent/{id}", method = RequestMethod.PUT)
    public ResponseEntity<MeteoEventDto> updateEvent(@PathVariable ("id") Long id, @RequestBody CreatingMeteoEventDto meteoEventDto) {
        MeteoEvent event = toCreatingModel(meteoEventDto);
        MeteoEvent eventCheck = this.meteoEventService.getById(id);
        if (eventCheck == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
       MeteoEvent updatedEvent = this.meteoEventService.update(event, id);
        return new ResponseEntity<>(toDto(updatedEvent), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<List<MeteoEventDto>> delete() {
        List<MeteoEvent> eventList = this.meteoEventService.getAll();

        for (MeteoEvent event : eventList) {
            this.meteoEventService.delete(event.getId());
        }

        return new ResponseEntity<>(Lists.transform(eventList, meteoEvent -> toDto(meteoEvent)), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<MeteoEventDto> deleteById(@PathVariable("id") Long id) {
        MeteoEvent event = this.meteoEventService.getById(id);
        if (event == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.meteoEventService.delete(event.getId());
        return new ResponseEntity<>(toDto(event), HttpStatus.OK);
    }

    private MeteoEventDto toDto(MeteoEvent meteoEvent) {
        return new MeteoEventDto.Builder()
                .precipitationLevel(meteoEvent.getPrecipitationLevel())
                .temperature(meteoEvent.getTemperature())
                .humidity(meteoEvent.getHumidity());
    }

    private MeteoEvent toCreatingModel(CreatingMeteoEventDto dto) {
        return new MeteoEventBuilder()
                .setHumidity(dto.getHumidity())
                .setPrecipitationLevel(dto.getPrecipitationLevel())
                .setTemperature(dto.getTemperature())
                .getMeteoEvent();
    }


}
