package com.EnvironmentDashboardModule1.controllers;

import com.EnvironmentDashboardModule1.DTO.CreatingEventDto;
import com.EnvironmentDashboardModule1.DTO.CreatingTornadoDto;
import com.EnvironmentDashboardModule1.DTO.EventDto;
import com.EnvironmentDashboardModule1.DTO.TornadoDto;
import com.EnvironmentDashboardModule1.models.Builders.TornadoBuilder;
import com.EnvironmentDashboardModule1.models.Event;
import com.EnvironmentDashboardModule1.models.Builders.EventBuilder;
import com.EnvironmentDashboardModule1.models.Tornado;
import com.EnvironmentDashboardModule1.services.EventService;
import com.EnvironmentDashboardModule1.services.TornadoService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Luca Andrei on 5/4/2017.
 */
@RestController
@RequestMapping("v1/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @Autowired
    private TornadoService tornadoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<EventDto>> get() {
        List<Event> events = this.eventService.getAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Lists.transform(events, event -> toDto(event)), HttpStatus.OK);
    }

    @RequestMapping(value = "/tornado", method = RequestMethod.GET)
    public ResponseEntity<List<TornadoDto>> getTornado() {
        List<Tornado> events = this.tornadoService.getAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Lists.transform(events, event -> toDto(event)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Event> addEvent(@RequestBody CreatingEventDto eventDto) {
        Event event = toCreatingModel(eventDto);
        Event savedEvent = this.eventService.save(event);
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/tornado", method = RequestMethod.POST)
    public ResponseEntity<Event> addEvent(@RequestBody Tornado event) {
        Event savedEvent = this.eventService.save(event);
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    private EventDto toDto(Event event) {
        return new EventDto.Builder()
                .name(event.getName())
                .latitude(event.getLatitude())
                .longitude(event.getLongitude())
                .startingDate(event.getStartingTime())
                .endingDate(event.getEndingTime())
                .severity(event.getSeverity())
                .description(event.getDescription())
                .hints(event.getHints())
                .radius(event.getRadius());
    }

    private Event toCreatingModel(CreatingEventDto dto) {
        return new EventBuilder()
                .setName(dto.getName())
                .setLongitude(dto.getLongitude())
                .setLatitude(dto.getLongitude())
                .setDescription(dto.getDescription())
                .setEndingTime(dto.getEndingDate())
                .setStartingTime(dto.getStartingDate())
                .setHints(dto.getHints())
                .setRadius(dto.getRadius())
                .setSeverity(dto.getSeverity())
                .getEvent();
    }

    private TornadoDto toDto(Tornado tornado) {
        return new TornadoDto.Builder()
                .name(tornado.getName())
                .latitude(tornado.getLatitude())
                .longitude(tornado.getLongitude())
                .startingDate(tornado.getStartingTime())
                .endingDate(tornado.getEndingTime())
                .severity(tornado.getSeverity())
                .description(tornado.getDescription())
                .hints(tornado.getHints())
                .radius(tornado.getRadius())
                .windspeed(tornado.getWindSpeed());
    }

    private Tornado toCreatingModel(CreatingTornadoDto dto) {
        return new TornadoBuilder()
                .setName(dto.getName())
                .setLongitude(dto.getLongitude())
                .setLatitude(dto.getLongitude())
                .setDescription(dto.getDescription())
                .setEndingTime(dto.getEndingDate())
                .setStartingTime(dto.getStartingDate())
                .setHints(dto.getHints())
                .setRadius(dto.getRadius())
                .setSeverity(dto.getSeverity())
                .setWindspeed(dto.getWindspeed())
                .getTornado();
    }
}