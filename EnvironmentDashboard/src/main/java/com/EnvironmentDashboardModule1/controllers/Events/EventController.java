package com.EnvironmentDashboardModule1.controllers.Events;

import com.EnvironmentDashboardModule1.DTO.CreatingEventDto;
import com.EnvironmentDashboardModule1.DTO.EventDto;
import com.EnvironmentDashboardModule1.models.Builders.EventBuilders.EventBuilder;
import com.EnvironmentDashboardModule1.models.EventMapping;
import com.EnvironmentDashboardModule1.models.Events.Event;
import com.EnvironmentDashboardModule1.services.Event.EventMappingService;
import com.EnvironmentDashboardModule1.services.Event.EventService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private EventMappingService eventMappingService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Event> addEvent(@RequestBody CreatingEventDto eventDto) {
        Event event = toCreatingModel(eventDto);
        Event savedEvent = this.eventService.save(event);
        if(event==null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        EventMapping eventMapping = new EventMapping(savedEvent.getId(), "Event");
        eventMappingService.save(eventMapping);

        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<EventDto>> get() {
        List<Event> events = this.eventService.getAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Lists.transform(events, event -> toDto(event)), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<EventDto> getById(@PathVariable("id") Long id) {
        Event event = this.eventService.getById(id);
        if (event == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(toDto(event), HttpStatus.OK);
    }

    @RequestMapping(value = "/event/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EventDto> updateEvent(@PathVariable("id") Long id, @RequestBody CreatingEventDto eventDto) {
        Event event = toCreatingModel(eventDto);
        Event eventCheck = this.eventService.getById(id);
        if (eventCheck == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Event updatedEvent = this.eventService.update(event, id);
        return new ResponseEntity<>(toDto(updatedEvent), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<List<EventDto>> delete() {
        List<Event> eventList = this.eventService.getAll();
        if(eventList == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        for (Event event : eventList) {
            this.eventService.delete(event.getId());
        }

        return new ResponseEntity<>(Lists.transform(eventList, event -> toDto(event)), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<EventDto> deleteById(@PathVariable("id") Long id) {
        Event event = this.eventService.getById(id);
        if (event == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.eventService.delete(event.getId());
        return new ResponseEntity<>(toDto(event), HttpStatus.OK);
    }

    public EventDto toDto(Event event) {
        return new EventDto.Builder()
                .userId(event.getUserId())
                .id(event.getId())
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
                .setUserId(dto.getUserId())
                .setName(dto.getName())
                .setLongitude(dto.getLongitude())
                .setLatitude(dto.getLatitude())
                .setDescription(dto.getDescription())
                .setEndingTime(dto.getEndingDate())
                .setStartingTime(dto.getStartingDate())
                .setHints(dto.getHints())
                .setRadius(dto.getRadius())
                .setSeverity(dto.getSeverity())
                .getEvent();
    }
}
