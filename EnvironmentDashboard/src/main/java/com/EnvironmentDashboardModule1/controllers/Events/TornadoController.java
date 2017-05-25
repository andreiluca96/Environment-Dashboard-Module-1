package com.EnvironmentDashboardModule1.controllers.Events;

import com.EnvironmentDashboardModule1.DTO.*;
import com.EnvironmentDashboardModule1.models.Builders.EventBuilders.EarthquakeBuilder;
import com.EnvironmentDashboardModule1.models.Builders.EventBuilders.TornadoBuilder;
import com.EnvironmentDashboardModule1.models.EventMapping;
import com.EnvironmentDashboardModule1.models.Events.Earthquake;
import com.EnvironmentDashboardModule1.models.Events.Event;
import com.EnvironmentDashboardModule1.models.Builders.EventBuilders.EventBuilder;
import com.EnvironmentDashboardModule1.models.Events.Tornado;
import com.EnvironmentDashboardModule1.services.EarthquakeService;
import com.EnvironmentDashboardModule1.services.EventMappingService;
import com.EnvironmentDashboardModule1.services.EventService;
import com.EnvironmentDashboardModule1.services.TornadoService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sabina on 5/8/2017.
 */

@RestController
@RequestMapping("v1/events")
public class TornadoController {
    @Autowired
    private EventService eventService;

    @Autowired
    private TornadoService tornadoService;

    @Autowired
    private EventMappingService eventMappingService;

    @RequestMapping(value = "/tornado", method = RequestMethod.POST)
    public ResponseEntity<Tornado> addTornado(@RequestBody CreatingTornadoDto event) {
        Tornado tornado = toCreatingModel(event);
        Tornado savedEvent = this.tornadoService.save(tornado);

        EventMapping eventMapping = new EventMapping(savedEvent.getId(), "Tornado");
        eventMappingService.save(eventMapping);

        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/tornado", method = RequestMethod.GET)
    public ResponseEntity<List<TornadoDto>> getTornados() {
        List<Tornado> events = this.tornadoService.getAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Lists.transform(events, event -> toDto(event)), HttpStatus.OK);
    }

    @RequestMapping(value = "/tornado/{id}", method = RequestMethod.GET)
    public ResponseEntity<TornadoDto> getTornadoById(@PathVariable("id") Long id) {
        Tornado tornado = this.tornadoService.getById(id);
        if (tornado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(toDto(tornado), HttpStatus.OK);
    }

    @RequestMapping(value = "/tornado/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TornadoDto> updateTornado(@PathVariable("id") Long id, @RequestBody CreatingTornadoDto tornadoDto) {
        Tornado tornado = toCreatingModel(tornadoDto);
        Tornado tornadoCheck = this.tornadoService.getById(id);
        if (tornadoCheck == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Tornado updatedTornado = this.tornadoService.update(tornado, id);
        return new ResponseEntity<>(toDto(updatedTornado), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/tornado", method = RequestMethod.DELETE)
    public ResponseEntity<List<TornadoDto>> deleteTornados() {
        List<Tornado> tornadoList = this.tornadoService.getAll();

        for (Tornado tornado : tornadoList) {
            this.eventService.delete(tornado.getId());
        }

        return new ResponseEntity<>(Lists.transform(tornadoList, event -> toDto(event)), HttpStatus.OK);
    }

    @RequestMapping(value = "tornado/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TornadoDto> deleteTornadoById(@PathVariable("id") Long id) {
        Tornado tornado = this.tornadoService.getById(id);
        if (tornado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.eventService.delete(tornado.getId());
        return new ResponseEntity<>(toDto(tornado), HttpStatus.OK);
    }

    private TornadoDto toDto(Tornado tornado) {
        return new TornadoDto.Builder()
                .id(tornado.getId())
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
