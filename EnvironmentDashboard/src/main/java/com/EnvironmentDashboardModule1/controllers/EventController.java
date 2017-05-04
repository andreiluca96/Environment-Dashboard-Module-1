package com.EnvironmentDashboardModule1.controllers;

import com.EnvironmentDashboardModule1.models.Earthquake;
import com.EnvironmentDashboardModule1.models.Event;
import com.EnvironmentDashboardModule1.services.EventService;
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

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Event>> get() {
        List<Event> events = this.eventService.getAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        Event savedEvent = this.eventService.save(event);
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/earthquake", method = RequestMethod.POST)
    public ResponseEntity<Event> addEvent(@RequestBody Earthquake event) {
        Event savedEvent = this.eventService.save(event);
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

}
